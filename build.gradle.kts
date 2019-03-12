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
        val dir = file("build/libs/templates-android-0.2.3.jar")
        if (dir.exists()) {
            classpath("com.github.voneskuba:templates-android:0.2.3")
        }
    }
}

plugins {
    idea
    id("java-gradle-plugin")
    id("maven-publish")
//    id("com.github.voneskuba.templates-android") version "0.2.3"
}

group = "com.github.voneskuba"
version = "0.2.3"

val dir = file("build/libs/templates-android-0.2.3.jar")
if (dir.exists()) {
    apply(plugin = "com.github.voneskuba.templates-android")
}

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
