rootProject.name = "templates-android"
rootProject.buildFileName = "build.gradle.kts"

pluginManagement {
    repositories {
        flatDir {
            dirs("build/libs")
        }
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == ProjectSettings.Templates.id) {
                useModule("${ProjectSettings.group}:${ProjectSettings.Templates.module}:${requested.version}")
            }
        }
    }
}
