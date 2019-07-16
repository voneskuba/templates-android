rootProject.name = "templates-android"
rootProject.buildFileName = "build.gradle.kts"

include(":templates")

pluginManagement {
    repositories {
        flatDir {
            dirs("templates/build/libs")
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
