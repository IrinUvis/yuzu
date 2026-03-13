import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import uvis.irin.yuzu.configureAndroidInstrumentedTests

class AndroidLibraryIntegrationTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        extensions.configure<LibraryExtension> {
            configureAndroidInstrumentedTests(this)
        }
    }
}
