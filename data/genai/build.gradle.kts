plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.detekt)
}

android {
    namespace = "uvis.irin.yuzu.core.genai"
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.mediapipe.tasks.genai)

    testImplementation(libs.junit)
}
