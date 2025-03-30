// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt) apply false

    alias(libs.plugins.module.graph)
}

moduleGraphConfig {
    readmePath.set("$rootDir/documentation/module-graph.md")
    heading = "# Module graph"
    showFullPath = false
}
