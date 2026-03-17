plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.library)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu.domain.wordgeneration"
}

dependencies {
    implementation(projects.data.wordgeneration)
    implementation(projects.data.genai)
    implementation(projects.core.logger)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlinx.collections.immutable)

    testImplementation(libs.junit)
}
