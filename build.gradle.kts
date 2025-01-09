import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "2.0.21"

    id("org.openapi.generator") version "7.10.0"
}

group = "dev.marsellus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

val openApi = tasks.withType<GenerateTask> {
    generatorName.set("kotlin")
    inputSpec.set("$projectDir/src/main/resources/schema.yaml")
    configOptions.set(mapOf("serializationLibrary" to "jackson"))

    generateModelDocumentation.set(false)
    generateModelTests.set(false)
    generateApiDocumentation.set(false)

    // Generates all models, excludes APIs and support files (unless named in their *ConstrainedTo)
    modelFilesConstrainedTo.set(listOf(""))

    modelPackage.set("dev.marsellus.model")

    sourceSets {
        main {
            kotlin {
                srcDir(layout.buildDirectory.dir("generate-resources/main/src/main/kotlin"))
            }
        }
    }
}

tasks.named("compileKotlin") {
    dependsOn(openApi)
}