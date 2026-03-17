pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "yuzu"
include(
    ":app",
    ":feature:wordgenerator",
    ":domain:wordgeneration",
    ":data:genai",
    ":data:wordgeneration",
    ":core:common",
    ":core:design-system",
    ":core:logger",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":domain:genai")
