import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.security.MessageDigest
import kotlin.text.split

val libs = project.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")!!
val lwjglVersion: String = libs.findVersion("lwjgl").orElseThrow().toString()

abstract class LwjglPlatform {
    abstract val name: Property<String>
    abstract val launcherOs: ListProperty<String>

    fun getJsonRules(): JsonArray {
        return JsonArray(launcherOs.get().map { osName -> JsonObject(mapOf(
            "action" to JsonPrimitive("allow"),
            "os" to JsonObject(mapOf(
                "name" to JsonPrimitive(osName)
            ))))}
        )
    }
}

fun makePlatform(name: String, launcherOs: List<String>): LwjglPlatform {
    val platform = project.objects.newInstance<LwjglPlatform>()
    platform.name = name
    platform.launcherOs = launcherOs
    return platform
}

data class LwjglBinding(val name: String, val hasNatives: Boolean = true) {
    fun getGav(): String {
        if (name.isEmpty()) {
            return "org.lwjgl:lwjgl:${lwjglVersion}"
        }
        return "org.lwjgl:lwjgl-${this.name}:${lwjglVersion}"
    }

    fun getNativeGav(platform: LwjglPlatform): String {
        return "${getGav()}:natives-${platform.name.get()}"
    }
}

private val supportedNatives = listOf(
    makePlatform("freebsd",listOf("freebsd")),
    makePlatform("linux-arm32",listOf("linux-arm32")),
    makePlatform("linux-arm64",listOf("linux-arm64")),
    makePlatform("linux-ppc64le",listOf("linux-ppc64le")),
    makePlatform("linux", listOf("linux")),
    makePlatform("macos-arm64", listOf("osx", "osx-arm64")),
    makePlatform("macos", listOf("osx")),
    makePlatform("windows-arm64", listOf("windows", "windows-arm64")),
    makePlatform("windows-x86", listOf("windows")),
    makePlatform("windows", listOf("windows"))
);

private val nativesByName: Map<String, LwjglPlatform> = supportedNatives.associateBy { n -> n.name.get() }

private val hostNativeClassifier = (project.extensions.getByName("lwjgl3Natives")!! as String).removePrefix("natives-")
private val hostNativePlatform = nativesByName[hostNativeClassifier]!!;

private val lwjgl3Bindings = listOf(
    LwjglBinding(""),
    LwjglBinding("freetype"),
    LwjglBinding("harfbuzz", false),
    LwjglBinding("jemalloc"),
    LwjglBinding("nuklear"),
    LwjglBinding("openal"),
    LwjglBinding("opengl"),
    LwjglBinding("sdl"),
    LwjglBinding("spng"),
    LwjglBinding("stb"),
    LwjglBinding("tinyfd"),
    LwjglBinding("zstd")
);


val allOfLwjgl3: Configuration = project.configurations.create("allOfLwjgl3")
val lwjgl3Classpath = project.configurations.getByName("lwjgl3Classpath")

for (binding in lwjgl3Bindings) {
    dependencies.add(lwjgl3Classpath.name, binding.getGav())
    dependencies.add(allOfLwjgl3.name, binding.getGav())
    if (binding.hasNatives) {
        dependencies.add(lwjgl3Classpath.name, binding.getNativeGav(hostNativePlatform))
        for (platform in supportedNatives) {
            dependencies.add(allOfLwjgl3.name, binding.getNativeGav(platform))
        }
    }
}

abstract class Lwjgl3JsonMaker : DefaultTask() {
    @get:Classpath
    abstract val libraries: ConfigurableFileCollection
    @get:OutputFile
    abstract val outputFile: RegularFileProperty
    @get:Input
    abstract val lwjglVersionString: Property<String>
    @get:Input
    abstract val lwjglNativesTable: MapProperty<String, LwjglPlatform>

    @TaskAction
    fun makeJson() {
        val sha1 = MessageDigest.getInstance("SHA-1")
        val outArr = mutableListOf<JsonObject>()
        val lwjglVersion = lwjglVersionString.get()
        for (file in libraries.files) {
            val fileName = file.name
            val fileSize = file.length()
            val fileSha1 = sha1.digest(file.readBytes()).joinToString("") { "%02x".format(it) }
            // Reconstruct maven GAV coordinates and URL from the file name
            var versionInterlude = "-${lwjglVersion}"
            var versionIdx = fileName.indexOf(versionInterlude)
            if (versionIdx == -1) {
                versionInterlude = "-3.4.0-SNAPSHOT"
                versionIdx = fileName.indexOf(versionInterlude)
            }
            if (versionIdx == -1) {
                logger.error("Could not determine lwjgl version in file $file")
                throw IllegalArgumentException("Could not determine lwjgl version in file $file")
            }
            val artifact = fileName.substring(0, versionIdx)
            val fileVersion = lwjglVersion
            val versionDash = lwjglVersion.indexOf('-')
            val urlVersion = if (versionDash >= 0) {lwjglVersion.substring(0, versionDash) + "-SNAPSHOT"} else {lwjglVersion}
            val classifier = fileName.substring(versionIdx + versionInterlude.length).removePrefix("-").removeSuffix(".jar")
            val dashClassifier = if (classifier.isEmpty()) {classifier} else { "-$classifier" }
            val gav = "org.lwjgl:${artifact}${dashClassifier}:${fileVersion}"
            /*
            {
                "downloads": {
                    "artifact": {
                        "sha1": "149070a5480900347071b7074779531f25a6e3dc",
                        "size": 1245129,
                        "url": "https://libraries.minecraft.net/org/lwjgl/lwjgl-freetype/3.3.3/lwjgl-freetype-3.3.3-natives-linux.jar"
                    }
                },
                "name": "org.lwjgl:lwjgl-freetype-natives-linux:3.3.3",
                "rules": [
                    {
                        "action": "allow",
                        "os": {
                            "name": "linux"
                        }
                    }
                ]
            },
            */
            val downloadUrl = if (urlVersion.contains("-SNAPSHOT")) {
                "https://nexus.gtnewhorizons.com/repository/central-sonatype-snapshots/org/lwjgl/${artifact}/${urlVersion}/${artifact}-${fileVersion}${dashClassifier}.jar"
            } else {
                // "https://libraries.minecraft.net/org/lwjgl/${artifact}/${urlVersion}/${artifact}-${fileVersion}${dashClassifier}.jar"
                // "https://build.lwjgl.org/release/${urlVersion}/bin/${artifact}/${artifact}${dashClassifier}.jar"
                "https://repo1.maven.org/maven2/org/lwjgl/${artifact}/${urlVersion}/${artifact}-${fileVersion}${dashClassifier}.jar"
            }
            val outObj = mutableMapOf(
                "downloads" to JsonObject(
                    mapOf(
                        "artifact" to JsonObject(
                            mapOf(
                                "sha1" to JsonPrimitive(fileSha1),
                                "size" to JsonPrimitive(fileSize),
                                "url" to JsonPrimitive(downloadUrl)
                            )
                        )
                    )
                ),
                "name" to JsonPrimitive(gav)
            )
            if (!classifier.isEmpty()) {
                val native: LwjglPlatform = lwjglNativesTable.get()[classifier.removePrefix("natives-")]
                    ?: throw IllegalStateException("Could not determine native for ${fileName}, classifier ${classifier}");
                outObj["rules"] = native.getJsonRules()
            }
            outArr += JsonObject(
                outObj
            )
        }
        outArr.sortBy { j -> (j["name"] as JsonPrimitive).toString() }
        outputFile.asFile.get().writeText(outArr.joinToString(",\n") { j -> j.toString() }, Charsets.UTF_8)
    }
}

tasks.register<Lwjgl3JsonMaker>("makeLwjgl3Json") {
    libraries = allOfLwjgl3
    outputFile = project.layout.buildDirectory.file("lwjgl3-libs.json")
    lwjglVersionString = lwjglVersion
    lwjglNativesTable = nativesByName
}
