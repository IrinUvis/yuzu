plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.library)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu.domain.genai"
}

dependencies {
    implementation(projects.data.genai)
    implementation(projects.core.logger)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    testImplementation(libs.junit)
}
