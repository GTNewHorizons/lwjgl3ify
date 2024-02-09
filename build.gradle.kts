import com.gtnewhorizons.retrofuturagradle.minecraft.RunMinecraftTask
import com.gtnewhorizons.retrofuturagradle.util.Distribution
import org.apache.tools.ant.filters.ReplaceTokens
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

val taskGroup = "lwjgl3ify"

val newJavaToolchainSpec: JavaToolchainSpec.() -> Unit = {
    vendor = JvmVendorSpec.AZUL
    languageVersion = JavaLanguageVersion.of(17)
}

val addOpens = listOf(
    "java.base/jdk.internal.loader=ALL-UNNAMED",
    "java.base/java.net=ALL-UNNAMED",
    "java.base/java.nio=ALL-UNNAMED",
    "java.base/java.io=ALL-UNNAMED",
    "java.base/java.lang=ALL-UNNAMED",
    "java.base/java.lang.reflect=ALL-UNNAMED",
    "java.base/java.text=ALL-UNNAMED",
    "java.base/java.util=ALL-UNNAMED",
    "java.base/jdk.internal.reflect=ALL-UNNAMED",
    "java.base/sun.nio.ch=ALL-UNNAMED",
    "jdk.naming.dns/com.sun.jndi.dns=ALL-UNNAMED,java.naming",
    "java.desktop/sun.awt.image=ALL-UNNAMED",
    "java.desktop/com.sun.imageio.plugins.png=ALL-UNNAMED",
    "jdk.dynalink/jdk.dynalink.beans=ALL-UNNAMED",
    "java.sql.rowset/javax.sql.rowset.serial=ALL-UNNAMED",
)

val extraJavaArgs = mutableListOf(
    "-Dfile.encoding=UTF-8",
    "-Djava.system.class.loader=com.gtnewhorizons.retrofuturabootstrap.RfbSystemClassLoader",
    "-Djava.security.manager=allow",
)
for (openSpec in addOpens) {
    extraJavaArgs += listOf("--add-opens", openSpec)
}

minecraft {
    injectedTags.put("RECOMMENDED_JAVA_ARGS", extraJavaArgs.joinToString("\t"))
}

lateinit var forgePatchesSet: SourceSet
lateinit var hotswapSet: SourceSet

sourceSets {
    create("util") {
        java {}
    }
    forgePatchesSet = create("forgePatches") {
        java {
            compileClasspath += mcpTasks.patchedMcSources.output
            compileClasspath += mcpTasks.patchedConfiguration
        }
    }
    hotswapSet = create("hotswap") {
        java {}
    }
    main {
        java {
            srcDirs += project.file("src/generated/java")
            compileClasspath = forgePatchesSet.output + compileClasspath
            runtimeClasspath = forgePatchesSet.output + runtimeClasspath
        }
    }
}

lateinit var forgePatchesEmbedded: Configuration
lateinit var versionJsonElements: Configuration

configurations {
    forgePatchesEmbedded = create("forgePatchesEmbedded") {
        isCanBeConsumed = false
        isCanBeResolved = true
    }
    versionJsonElements = create("versionJsonElements") {
        isCanBeConsumed = false
        isCanBeResolved = false
    }
    named("forgePatchesImplementation") { extendsFrom(forgePatchesEmbedded) }
    patchedMinecraft { extendsFrom(forgePatchesEmbedded) }
}

tasks.shadowJar {
    from(hotswapSet.output)
}

tasks.named<JavaCompile>("compileForgePatchesJava").configure {
    dependsOn("packagePatchedMc", "packageMcLauncher")
}

tasks.named<JavaCompile>("compileHotswapJava").configure {
    javaCompiler = javaToolchains.compilerFor(newJavaToolchainSpec)
    sourceCompatibility = JavaVersion.VERSION_17.majorVersion
    targetCompatibility = JavaVersion.VERSION_17.majorVersion
}

tasks.createMcLauncherFiles {
    // Override main class
    replacementTokens.put("@@BOUNCERCLIENT@@", "com.gtnewhorizons.retrofuturabootstrap.Main")
    replacementTokens.put("@@BOUNCERSERVER@@", "com.gtnewhorizons.retrofuturabootstrap.Main")
}

val forgePatchesJar = tasks.register<Jar>(forgePatchesSet.jarTaskName) {
    group = taskGroup
    description = "Packages the forgePatches jar"
    from(forgePatchesSet.output)
    // Bootleg shadow jar
    forgePatchesEmbedded.resolve().forEach { dep ->
        from(zipTree(dep)) {
            filesMatching("META-INF/*") {
                this.name = "${dep.name}-${this.name}"
            }
        }
    }
    exclude("module-info.class")
    exclude("META-INF/versions/9/module-info.class")
    exclude("log4j2.xml")
    archiveClassifier.set("forgePatches")
    manifest {
        val libraryList = listOf(
            "libraries/com/typesafe/akka/akka-actor_2.11/2.3.3/akka-actor_2.11-2.3.3.jar",
            "libraries/com/typesafe/config/1.2.1/config-1.2.1.jar",
            "libraries/org/scala-lang/scala-actors-migration_2.11/1.1.0/scala-actors-migration_2.11-1.1.0.jar",
            "libraries/org/scala-lang/scala-compiler/2.11.1/scala-compiler-2.11.1.jar",
            "libraries/org/scala-lang/plugins/scala-continuations-library_2.11/1.0.2/scala-continuations-library_2.11-1.0.2.jar",
            "libraries/org/scala-lang/plugins/scala-continuations-plugin_2.11.1/1.0.2/scala-continuations-plugin_2.11.1-1.0.2.jar",
            "libraries/org/scala-lang/scala-library/2.11.1/scala-library-2.11.1.jar",
            "libraries/org/scala-lang/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar",
            "libraries/org/scala-lang/scala-reflect/2.11.1/scala-reflect-2.11.1.jar",
            "libraries/org/scala-lang/scala-swing_2.11/1.0.1/scala-swing_2.11-1.0.1.jar",
            "libraries/org/scala-lang/scala-xml_2.11/1.0.2/scala-xml_2.11-1.0.2.jar",
            "libraries/lzma/lzma/0.0.1/lzma-0.0.1.jar",
            "libraries/net/sf/jopt-simple/jopt-simple/4.5/jopt-simple-4.5.jar",
            "libraries/com/google/guava/guava/17.0/guava-17.0.jar",
            "forge-1.7.10-10.13.4.1614-1.7.10-universal.jar",
            "minecraft_server.1.7.10.jar"
        )
        attributes(
            mapOf(
                "Class-Path" to libraryList.joinToString(" "),
                "Main-Class" to "me.eigenraven.lwjgl3ify.rfb.entry.ServerMain"
            )
        )
    }
}

val mmcInstanceFilesZip = tasks.register<Zip>("mmcInstanceFiles") {
    group = taskGroup
    description = "Packages the MultiMC patches"
    dependsOn(forgePatchesJar)
    archiveClassifier.set("multimc")
    from(project.file("prism-libraries/"))
    from(forgePatchesJar) {
        into("libraries/")
    }
    exclude("forgepatches-for-dev-work.json", "META-INF", "META-INF/**")
    filesMatching(listOf("mmc-pack.json", "patches/me.eigenraven.lwjgl3ify.forgepatches.json")) {
        expand(
            mapOf(
                "version" to project.version,
                "jvmArgs" to extraJavaArgs.map { '"' + it + '"' }.joinToString(", ")
            )
        )
    }
}

val versionJsonPath = layout.buildDirectory.file("libs/version.json").get().asFile

val versionJsonFile = tasks.register("versionJson") {
    group = taskGroup
    description = "Generates the vanilla launcher version.json file"
    dependsOn("reobfJar")
    inputs.file("launcher-metadata/version.json")
    inputs.property("version", project.version)
    inputs.property("jvmArgs", extraJavaArgs)
    outputs.file(versionJsonPath)
    doLast {
        versionJsonPath.parentFile.mkdirs()
        copy {
            from("launcher-metadata/version.json")
            into(versionJsonPath.parentFile)
            filter(
                ReplaceTokens::class, "tokens" to mapOf(
                    "version" to project.version,
                    "jvmArgs" to extraJavaArgs.map { '"' + it + '"' }.joinToString(", "),
                    "time" to DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.now(ZoneOffset.UTC))
                )
            )
        }
    }
}

val versionJsonArtifact = artifacts.add("versionJsonElements", versionJsonPath) {
    type = "json"
    classifier = "version"
    builtBy(versionJsonFile)
}

tasks.named("assemble").configure {
    dependsOn(forgePatchesSet.jarTaskName)
    dependsOn(mmcInstanceFilesZip)
    dependsOn(versionJsonFile)
}

val runComparisonTool = tasks.register<JavaExec>("runComparisonTool") {
    group = taskGroup
    description = "Runs the 2<->3 mapping generation"
    classpath(sourceSets.named("util").map { it.runtimeClasspath })
    dependsOn("jar")
    mainClass.set("me.eigenraven.lwjgl3ify.ComparisonTool")
    minHeapSize = "2G"
    maxHeapSize = "2G"
}

tasks.processResources {
    inputs.property("version", project.version.toString())
    filesMatching("META-INF/rfb-plugin/*") {
        expand("version" to project.version.toString())
    }
}

afterEvaluate {
    publishing.publications.named<MavenPublication>("maven") {
        artifact(forgePatchesJar)
        artifact(mmcInstanceFilesZip)
        artifact(versionJsonArtifact)
    }

    val lwjgl2Zips = configurations.named("lwjgl2Classpath").get().resolve()
        .filter { !it.name.contains("natives") && !it.path.contains("net.java.j") }
    val lwjgl3Zips = configurations.named("lwjgl3Classpath").get().resolve().filter { !it.name.contains("natives") }
    val lwjgl2Args = lwjgl2Zips.map { "--2:" + it }
    val lwjgl3Args = lwjgl3Zips.map { "--3:" + it }
    runComparisonTool.configure {
        val allArgs = lwjgl2Args + lwjgl3Args + listOf("--M:" + tasks.jar.get().archiveFile.get().asFile.path)
        args(allArgs)
    }
}

val veryNewJavaToolchainSpec: JavaToolchainSpec.() -> Unit = {
    vendor = JvmVendorSpec.AZUL
    languageVersion = JavaLanguageVersion.of(21)
}

val newJavaLauncher = javaToolchains.launcherFor(veryNewJavaToolchainSpec)

for (jarTask in listOf("jar", "shadowJar", "forgePatchesJar")) {
    tasks.named<Jar>(jarTask).configure {
        manifest {
            attributes("Multi-Release" to true)
        }
    }
}

for (runTask in listOf(tasks.runClient, tasks.runServer)) {
    runTask.configure {
        classpath = forgePatchesSet.output + classpath
        extraJvmArgs = extraJavaArgs
        javaLauncher.set(newJavaLauncher)
    }
}

for (runTask in listOf(tasks.runObfClient, tasks.runObfServer)) {
    runTask.configure {
        classpath = files(forgePatchesJar) + classpath
        extraJvmArgs = extraJavaArgs
        javaLauncher.set(newJavaLauncher)
    }
}

val originalLaunchWrapperPath = project.layout.buildDirectory.file("launchwrapper-1.12.jar").get().asFile

val runWithRelauncher = tasks.register<RunMinecraftTask>("runClientWithRelauncher", Distribution.CLIENT, gradle)
runWithRelauncher.configure {
    setup(project)
    group = "lwjgl3ify"
    description = "Runs the deobfuscated client while triggering the relauncher"
    dependsOn(
        sourceSets.mcLauncher.map { it.classesTaskName },
        tasks.downloadVanillaAssets,
        tasks.packagePatchedMc,
        "jar"
    )

    username = minecraft.username
    userUUID = minecraft.userUUID
    lwjglVersion = 2

    systemProperty("gradlestart.bouncerClient", "net.minecraft.launchwrapper.Launch")

    classpath(tasks.packageMcLauncher)
    classpath(tasks.packagePatchedMc)
    classpath(originalLaunchWrapperPath)
    classpath(configurations.patchedMinecraft)
    classpath(tasks.jar)
    classpath(configurations.runtimeClasspath)
    mainClass = "GradleStart"

    doFirst {
        download.run {
            src("https://libraries.minecraft.net/net/minecraft/launchwrapper/1.12/launchwrapper-1.12.jar")
            dest(originalLaunchWrapperPath)
            overwrite(false)
        }
    }
}

tasks.runObfClient {
    mainClass.set("com.gtnewhorizons.retrofuturabootstrap.Main")
}

tasks.runObfServer {
    tweakClasses.set(listOf())
}

// Regular runClient/runServer tasks run in Java 17 in this project.
tasks.runClient17 { enabled = false }
tasks.runClient21 { enabled = false }
tasks.runServer17 { enabled = false }
tasks.runServer21 { enabled = false }

tasks.jar {
    manifest.attributes.put("TweakClass", "me.eigenraven.lwjgl3ify.relauncher.Lwjgl3ifyRelauncherTweaker")
}

tasks.shadowJar {
    manifest.attributes.put("TweakClass", "me.eigenraven.lwjgl3ify.relauncher.Lwjgl3ifyRelauncherTweaker")
}

apply(from = "dependencies.gradle")
