import uvis.irin.yuzu.YuzuBuildType

plugins {
    alias(libs.plugins.uvis.irin.android.application)
    alias(libs.plugins.uvis.irin.android.applicationCompose)
    alias(libs.plugins.uvis.irin.detekt)
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
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}