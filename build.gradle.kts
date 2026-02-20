import net.ltgt.gradle.errorprone.errorprone

plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
    alias(libs.plugins.errorprone)
    alias(libs.plugins.paperweight.userdev)
}

group = "xyz.bitsquidd.scaffold"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven ("https://jitpack.io")
}

dependencies {
    // Paperweight for NMS & Paper API
    paperweight.paperDevBundle(libs.versions.paper.api.get())

    // Utility libraries
    implementation("com.github.ImBit.Bits:API:0.0.6")
    implementation("com.github.ImBit.Bits:Paper:0.0.6")

    // Error tracking
    errorprone(libs.errorprone)
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.errorprone.isEnabled.set(true)
    options.errorprone.disableWarningsInGeneratedCode.set(true)
    options.errorprone.disableAllWarnings.set(true)
    options.errorprone.errorproneArgs.addAll(
        listOf(
            "-Xep:CollectionIncompatibleType:ERROR",
            "-Xep:EqualsIncompatibleType:ERROR",

            "-Xep:MissingOverride:ERROR",
            "-Xep:SelfAssignment:ERROR",
            "-Xep:StreamResourceLeak:ERROR",

            "-Xep:CanonicalDuration:OFF",
            "-Xep:InlineMeSuggester:OFF",
            "-Xep:ImmutableEnumChecker:OFF"
        )
    )
}

tasks.javadoc { options.encoding = "UTF-8" }

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    withSourcesJar()
    withJavadocJar()
}