plugins {
    alias(libs.plugins.openapiGenerator)
}

dependencies {
    api(libs.swaggerAnnotations)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

openApiGenerate {
    inputSpec.set("$projectDir/src/main/resources/springDoc-service-api.json")
    generatorName.set("java")
    outputDir.set("$projectDir/build/generated/springDoc-client")
    groupId.set(("org.example"))
    apiPackage.set("org.example.api.v1")
    modelPackage.set("org.example.api.v1")
    ignoreFileOverride.set("$rootDir/springDoc-client/.openApi-ignore")
    enablePostProcessFile.set(false)
    validateSpec.set(false)
    library.set("resttemplate")
    skipValidateSpec.set(false)
    generateApiDocumentation.set(false)
    generateApiTests.set(false)
    generateModelDocumentation.set(false)
    generateModelTests.set(false)

    globalProperties.set(
        mapOf(
            "apis" to "",
            "invokers" to "",
            "supportingFiles" to "ApiClient.java"
        )
    )
}

tasks.withType<JavaCompile>() {
    dependsOn("openApiGenerate")
}

task<Jar>("sourceJar") {
    from(sourceSets.main.get().allJava)
}

tasks.named("sourceJar") {
    dependsOn(tasks.named("openApiGenerate"))
}

tasks.withType<ProcessResources>() {
    dependsOn(tasks.named("openApiGenerate"))
}
