plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.android.libraryCompose)
    alias(libs.plugins.uvis.irin.android.libraryIntegrationTest)
}

android {
    namespace = "uvis.irin.feature.wordgenerator"
}

dependencies {
    implementation(projects.core.common)

    testImplementation(libs.junit)
}