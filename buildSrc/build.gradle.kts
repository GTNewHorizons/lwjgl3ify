import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    embeddedKotlin("plugin.serialization")
}

repositories {
    gradlePluginPortal()
}

tasks.compileKotlin.configure {
    compilerOptions.jvmTarget = JvmTarget.JVM_24
}

tasks.compileJava.configure {
    options.release = 24
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}
