import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.enterprise.test.FileProperty
import java.io.File
import java.security.MessageDigest

val libs = project.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")!!
val lwjglVersion: String = libs.findVersion("lwjgl").orElseThrow().toString()

data class LwjglPlatform(val name: String) {
    //
}

data class LwjglBinding(val name: String, val hasNatives: Boolean = true) {
    fun getGav(): String {
        if (name.isEmpty()) {
            return "org.lwjgl:lwjgl:${lwjglVersion}"
        }
        return "org.lwjgl:lwjgl-${this.name}:${lwjglVersion}"
    }

    fun getNativeGav(platform: LwjglPlatform): String {
        return "${getGav()}:natives-${platform.name}"
    }
}

private val supportedNatives = listOf(
    LwjglPlatform("freebsd"),
    LwjglPlatform("linux-arm32"),
    LwjglPlatform("linux-arm64"),
    LwjglPlatform("linux-ppc64le"),
    LwjglPlatform("linux"),
    LwjglPlatform("macos-arm64"),
    LwjglPlatform("macos"),
    LwjglPlatform("windows-arm64"),
    LwjglPlatform("windows-x86"),
    LwjglPlatform("windows")
);

private val hostNativeClassifier = (project.extensions.getByName("lwjgl3Natives")!! as String).removePrefix("natives-")
private val hostNativePlatform = supportedNatives.find { el -> el.name == hostNativeClassifier }!!;

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

    @TaskAction
    fun makeJson() {
        val sha1 = MessageDigest.getInstance("SHA-1")
        val outArr = mutableListOf<JsonObject>()
        for (file in libraries.files) {
            val fileName = file.name
            val fileSize = file.length()
            val fileSha1 = sha1.digest(file.readBytes()).joinToString("") { "%02x".format(it) }
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
            outArr += JsonObject(
                mapOf(
                    "downloads" to JsonObject(
                        mapOf(
                            "artifact" to JsonObject(
                                mapOf(
                                    "sha1" to JsonPrimitive(fileSha1),
                                    "size" to JsonPrimitive(fileSize),
                                    "url" to JsonPrimitive(fileName)
                                )
                            )
                        )
                    ),
                    "name" to JsonPrimitive(fileName)
                )
            )
        }
        outArr.sortBy { j -> (j["name"] as JsonPrimitive).toString() }
        outputFile.asFile.get().writeText(outArr.joinToString(",\n") { j -> j.toString() }, Charsets.UTF_8)
    }
}

tasks.register<Lwjgl3JsonMaker>("makeLwjgl3Json") {
    libraries = allOfLwjgl3
    outputFile = project.layout.buildDirectory.file("lwjgl3-libs.json")
}
