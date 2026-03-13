# Detekt

The project has Detekt Gradle plugin set up. It takes care of ensuring high code quality and standardizing linting ruleset.

## Configuration

Detekt plugin is configured in [DetektConventionPlugin.kt](./../build-logic/convention/src/main/kotlin/DetektConventionPlugin.kt).

Its ruleset is defined in [detekt.yml](./../config/detekt/detekt.yml).

## Usage

In order to apply Detekt plugin to a module, apply this convention plugin to it via:

```kotlin
plugins {
    alias(libs.plugins.uvis.irin.yuzu.detekt)
}
```

In order to run Detekt manually run:

```shell
./gradlew detekt
```

## Automatic pre-commit checks

The project allows to quickly setup automatic Detekt checks to be run before every commit. This is accomplished via precommit Git hook.

In order to install the precommit Git hook that runs Detekt check run:

```shell
./gradlew installDetektGitHook
```
