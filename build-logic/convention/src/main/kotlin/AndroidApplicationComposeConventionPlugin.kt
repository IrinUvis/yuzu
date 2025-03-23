import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType
import uvis.irin.yuzu.configureCompose
import uvis.irin.yuzu.findLibsPlugin

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(findLibsPlugin("android-application").pluginId)
            apply(findLibsPlugin("kotlin-compose").pluginId)
        }

        val extension = extensions.getByType<ApplicationExtension>()
        configureCompose(extension)
    }
}
