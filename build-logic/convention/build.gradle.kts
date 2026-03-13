import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "uvis.irin.yuzu.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "uvis.irin.yuzu.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "uvis.irin.yuzu.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "uvis.irin.yuzu.android.applicationCompose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "uvis.irin.yuzu.android.libraryCompose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationIntegrationTest") {
            id = "uvis.irin.yuzu.android.applicationIntegrationTest"
            implementationClass = "AndroidApplicationIntegrationTestConventionPlugin"
        }
        register("androidLibraryIntegrationTest") {
            id = "uvis.irin.yuzu.android.libraryIntegrationTest"
            implementationClass = "AndroidLibraryIntegrationTestConventionPlugin"
        }
        register("detekt") {
            id = "uvis.irin.yuzu.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("jvmLibrary") {
            id = "uvis.irin.yuzu.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}