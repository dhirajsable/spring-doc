plugins {
    alias(libs.plugins.springBoot)
}

dependencies {
    api(libs.springBootStarterWeb)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
