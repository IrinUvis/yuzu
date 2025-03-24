package uvis.irin.yuzu

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureAndroidInstrumentedTests(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) = with(commonExtension) {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
