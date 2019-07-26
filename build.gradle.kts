buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        flatDir {
            dirs("templates/build/libs")
        }
    }
    dependencies {
        classpath(Dependencies.gradlePlugin)
        classpath(Dependencies.Plugins.androidMaven)
        classpath(kotlin(Dependencies.Kotlin.gradlePlugin, Versions.kotlin))
    }
}

plugins {
    idea
    id(ProjectSettings.Templates.id) version ProjectSettings.version
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
