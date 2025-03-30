plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.detekt)
}

android {
    namespace = "uvis.irin.yuzu.domain.wordgeneration"
}

dependencies {
    implementation(projects.data.wordgeneration)

    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlinx.collections.immutable)

    testImplementation(libs.junit)
}
