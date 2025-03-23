import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.detekt)
}

group = "uvis.irin.yuzu.build-logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

detekt {
    config.setFrom(File(rootProject.rootDir, "./../config/detekt/detekt.yml"))
    autoCorrect = true
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)

    detektPlugins(libs.detekt.formatting)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "uvis.irin.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "uvis.irin.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "uvis.irin.android.applicationCompose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "uvis.irin.android.libraryCompose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("detekt") {
            id = "uvis.irin.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("jvmLibrary") {
            id = "uvis.irin.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}