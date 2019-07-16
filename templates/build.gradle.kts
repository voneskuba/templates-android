plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("maven-publish")
}

group = ProjectSettings.group
version = ProjectSettings.version

repositories {
    jcenter()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

gradlePlugin {
    plugins {
        create(ProjectSettings.Templates.name) {
            id = ProjectSettings.Templates.id
            implementationClass = ProjectSettings.Templates.implementationClass
        }
    }
}
