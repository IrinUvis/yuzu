plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.android.libraryCompose)
    alias(libs.plugins.uvis.irin.android.libraryIntegrationTest)
    alias(libs.plugins.uvis.irin.detekt)
}

android {
    namespace = "uvis.irin.feature.wordgenerator"
}

dependencies {
    api(projects.core.designSystem)

    implementation(projects.core.common)

    testImplementation(libs.junit)
}