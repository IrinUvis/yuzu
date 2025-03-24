import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import uvis.irin.yuzu.findLibsPlugin
import uvis.irin.yuzu.libs
import java.io.File
import io.gitlab.arturbosch.detekt.Detekt

class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(findLibsPlugin("detekt").pluginId)
        }

        configureDetekt()
        registerInstallGitHooksTask()
    }

    private fun Project.configureDetekt() {
        extensions.configure<DetektExtension> {
            config.setFrom(File(rootProject.rootDir, "./config/detekt/detekt.yml"))
            autoCorrect = true
        }

        tasks.withType<Detekt>().configureEach {
            if (project.hasProperty(DETEKT_PRE_COMMIT_PROPERTY)) {
                val rootDir = project.rootDir
                val projectDir = projectDir

                val fileCollection = files()

                setSource(
                    getGitStagedFiles(rootDir)
                        .map { stagedFiles ->
                            val stagedFilesFromThisProject = stagedFiles
                                .filter { it.startsWith(projectDir) }

                            fileCollection.setFrom(*stagedFilesFromThisProject.toTypedArray())

                            fileCollection.asFileTree
                        }
                )
            }
        }

        afterEvaluate {
            tasks.withType(Detekt::class.java).configureEach {
                val typeResolutionEnabled = !classpath.isEmpty
                if (typeResolutionEnabled && project.hasProperty(DETEKT_PRE_COMMIT_PROPERTY)) {
                    // We must exclude kts files from pre-commit hook to prevent detekt from crashing
                    // This is a workaround for the https://github.com/detekt/detekt/issues/5501
                    exclude("*.gradle.kts")
                }
            }
        }

        dependencies {
            "detektPlugins"(libs.findLibrary("detekt-formatting").get())
        }
    }

    private fun Project.getGitStagedFiles(rootDir: File): Provider<List<File>> {
        return providers.exec {
            commandLine("git", "--no-pager", "diff", "--name-only", "--cached")
        }.standardOutput.asText
            .map { outputText ->
                outputText.trim()
                    .split("\n")
                    .filter { it.isNotBlank() }
                    .map { File(rootDir, it) }
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

    companion object {
        private const val DETEKT_PRE_COMMIT_PROPERTY = "precommit"
    }
}
