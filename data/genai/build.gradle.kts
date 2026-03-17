plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.library)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu.core.genai"

    androidResources {
        noCompress.add("task")
    }
}

dependencies {
    implementation(projects.core.logger)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.mlkit.genai.prompt)

    testImplementation(libs.junit)
}
