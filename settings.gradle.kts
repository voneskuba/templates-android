rootProject.name = "templates-android"
rootProject.buildFileName = "build.gradle.kts"

include(":templates")

pluginManagement {
    repositories {
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        gradlePluginPortal()
        flatDir {
            dirs("templates/build/libs")
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == ProjectSettings.Templates.id) {
                useModule("${ProjectSettings.group}:${ProjectSettings.Templates.module}:${requested.version}")
            }
        }
    }
}
