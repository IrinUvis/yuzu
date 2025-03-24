plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.android.libraryCompose)
}

android {
    namespace = "uvis.irin.feature.wordgenerator"
}

dependencies {
    testImplementation(libs.junit)
}