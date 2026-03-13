plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.library)
    alias(libs.plugins.uvis.irin.yuzu.android.libraryCompose)
    alias(libs.plugins.uvis.irin.yuzu.android.libraryIntegrationTest)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu.feature.wordgenerator"
}

dependencies {
    api(projects.core.designSystem)

    implementation(projects.domain.wordgeneration)
    implementation(projects.core.common)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core.viewmodel)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.koin.compose.navigation)

    testImplementation(libs.junit)
}
