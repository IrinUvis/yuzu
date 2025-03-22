package uvis.irin.yuzu

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.findLibsVersion(name: String): String = libs.findVersion(name).get().requiredVersion