plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "spring-doc"
include(":springDoc-service")
include("springDoc-client")
