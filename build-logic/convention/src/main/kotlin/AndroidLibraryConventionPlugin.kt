import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import uvis.irin.yuzu.configureKotlinAndroid
import uvis.irin.yuzu.findLibsPlugin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(findLibsPlugin("android-library").pluginId)
        }

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
        }
    }
}
