plugins {
    alias(libs.plugins.uvis.irin.android.library)
    alias(libs.plugins.uvis.irin.detekt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "uvis.irin.yuzu.data.wordgenerator"
}

dependencies {
    implementation(projects.core.logger)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.datastore.proto)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.collections.immutable)

    testImplementation(libs.junit)
}
