plugins {
    alias(libs.plugins.springBoot)
}

dependencies {
    api(libs.springBootStarterWeb)

    api(libs.swaggerAnnotations)
    api(libs.springdocOpenapiStarter)

    api(libs.springBootStarterTest)
}
