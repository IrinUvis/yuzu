import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.register
import uvis.irin.yuzu.libs
import java.io.File

class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("io.gitlab.arturbosch.detekt")
        }

        configureDetekt()
        registerInstallGitHooksTask()
    }

    private fun Project.configureDetekt() {
        extensions.configure<DetektExtension> {
            config.setFrom(File(rootProject.rootDir, "./config/detekt/detekt.yml"))
            autoCorrect = true
        }

        dependencies {
            "detektPlugins"(libs.findLibrary("detekt-formatting").get())
        }
    }

    private fun Project.registerInstallGitHooksTask() {
        tasks.register<Copy>("installGitHooks") {
            description = "Installs the pre-commit git hook"
            from(File(rootProject.rootDir, "scripts/pre-commit"))
            into(File(rootProject.rootDir, ".git/hooks"))

            // Set executable permission using filePermissions
            filePermissions {
                user {
                    read = true
                    write = true
                    execute = true
                }
                group {
                    read = true
                    execute = true
                }
                other {
                    read = true
                    execute = true
                }
            }
        }
    }
}