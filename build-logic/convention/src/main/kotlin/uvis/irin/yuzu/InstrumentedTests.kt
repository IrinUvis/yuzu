package uvis.irin.yuzu

import com.android.build.api.dsl.CommonExtension

internal fun configureAndroidInstrumentedTests(
    commonExtension: CommonExtension,
) = with(commonExtension) {
    defaultConfig.apply {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
