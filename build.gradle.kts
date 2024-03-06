plugins {
    kotlin("jvm") version "1.9.21"
    id("java-library")
    id("maven-publish")
    alias(libs.plugins.spotless)
    alias(libs.plugins.springManagement)
    alias(libs.plugins.springBoot) apply(false)
    alias(libs.plugins.openapi) apply(false)
    alias(libs.plugins.swaggerGenerator) apply(false)
    alias(libs.plugins.docker) apply(false)
    alias(libs.plugins.freefairLombok)
}

allprojects {
    apply {
        plugin("java-library")
        plugin("groovy")
    }

//    spotless {
//        java {
//            googleJavaFormat("1.15.0")
//            indentWithTabs(2)
//            indentWithSpaces(4)
//        }
//    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
        withSourcesJar()
    }

    dependencies {
        implementation(platform(rootProject.libs.springBootBom))
        implementation(platform(rootProject.libs.springCloudBom))
        implementation(platform(rootProject.libs.kotlinBom))
        implementation(platform(rootProject.libs.resilience4jBom))
        implementation(rootProject.libs.slf4jApi)
        implementation(rootProject.libs.googlejavaformat)
        implementation(rootProject.libs.bundles.testFrameworkCompiler)
        implementation(rootProject.libs.bundles.testFrameworkRuntime)
    }

    tasks.named<Test>("test") {
        useJUnitPlatform()
    }

    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://repo.spring.io/release")
        }
        maven {
            url = uri("https://repo.spring.io/snapshot")
        }
        maven {
            url = uri("https://repository.jboss.org/maven2")
        }
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }

}

lombok {
    version.set(rootProject.libs.versions.lombok)
}
