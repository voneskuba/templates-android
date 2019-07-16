import org.vones.templates.Templates

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        flatDir {
            dirs("build/libs")
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
    id("java-gradle-plugin")
    id("maven-publish")
//    id(ProjectSettings.Templates.id) version ProjectSettings.version
}

apply<Templates>()

group = ProjectSettings.group
version = ProjectSettings.version

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

gradlePlugin {
    plugins {
        create(ProjectSettings.Templates.name) {
            id = ProjectSettings.Templates.id
            implementationClass = ProjectSettings.Templates.implementationClass
        }
    }
}
