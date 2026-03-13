import uvis.irin.yuzu.YuzuBuildType

plugins {
    alias(libs.plugins.uvis.irin.yuzu.android.application)
    alias(libs.plugins.uvis.irin.yuzu.android.applicationCompose)
    alias(libs.plugins.uvis.irin.yuzu.android.applicationIntegrationTest)
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}

android {
    namespace = "uvis.irin.yuzu"

    defaultConfig {
        applicationId = "uvis.irin.yuzu"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = YuzuBuildType.DEBUG.applicationIdSuffix
        }
        release {
            applicationIdSuffix = YuzuBuildType.RELEASE.applicationIdSuffix
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(projects.feature.wordgenerator)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
