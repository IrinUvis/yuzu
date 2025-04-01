plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.detekt)
}

android {
    namespace = "uvis.irin.yuzu.core.genai"
}

dependencies {
    implementation(libs.mediapipe.tasks.genai)

    testImplementation(libs.junit)
}
