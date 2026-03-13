plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.library)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu.core.logger"
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(libs.kermit.logger)
}
