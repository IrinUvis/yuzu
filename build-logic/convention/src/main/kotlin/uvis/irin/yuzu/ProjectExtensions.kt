package uvis.irin.yuzu

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.findLibsPlugin(name: String): PluginDependency = libs.findPlugin(name).get().get()
