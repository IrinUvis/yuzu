import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import uvis.irin.yuzu.configureKotlinAndroid
import uvis.irin.yuzu.findLibsPlugin
import uvis.irin.yuzu.findLibsVersion

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(findLibsPlugin("android-application").pluginId)
            apply(findLibsPlugin("kotlin-android").pluginId)
        }

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)

            defaultConfig.targetSdk = findLibsVersion("targetSdk").toInt()
        }
    }
}