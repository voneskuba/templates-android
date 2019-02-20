import org.vones.templates.Templates

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
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
}

group = "com.github.voneskuba"
version = "0.2.0"

apply<Templates>()

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
        create("copyTemplates") {
            id = "com.github.voneskuba.templates-android"
            implementationClass = "org.vones.templates.Templates"
        }
    }
}
