plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    alias(libs.plugins.kotlinJvm)
    application
//    alias(libs.)
}

group = "tax.bilibili"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

kotlin {

}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//    implementation("cn.dev33:sa-token-spring-boot3-starter:1.37.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("io.projectreactor:reactor-test")
    runtimeOnly("io.asyncer:r2dbc-mysql:1.1.0")
    runtimeOnly("org.postgresql:r2dbc-postgresql:1.0.5.RELEASE")
    runtimeOnly("io.r2dbc:r2dbc-mssql:1.0.0.RELEASE")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}