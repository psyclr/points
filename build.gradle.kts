import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.3"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
    id("org.liquibase.gradle") version "2.0.1"
}

group = "com.anymind"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    liquibaseRuntime("org.liquibase:liquibase-core:4.8.0")
    liquibaseRuntime("org.postgresql:postgresql")
    liquibaseRuntime("org.yaml:snakeyaml:1.29")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
liquibase {
    activities.register("main") {
        val db_url by project.extra.properties
        val db_user by project.extra.properties
        val db_password by project.extra.properties

        this.arguments = mapOf(
                "logLevel" to "info",
                "changeLogFile" to "src/main/resources/db/changelog.yml",
                "url" to db_url,
                "username" to db_user,
                "password" to db_password,
                "driver" to "com.mysql.cj.jdbc.Driver"
        )
    }
    runList = "main"
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
