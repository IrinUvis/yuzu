import org.gradle.api.Plugin
import org.gradle.api.Project
import uvis.irin.yuzu.configureKotlinJvm
import uvis.irin.yuzu.findLibsPlugin

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(findLibsPlugin("kotlin-jvm").pluginId)
        }

        configureKotlinJvm()
    }
}
