plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    alias(libs.plugins.kotlinJvm)
    application
}

group = "tax.bilibili.nineblog"
version = "0.0.1-SNAPSHOT"

java {
}

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.springframework:spring-context:6.1.11")
//    compileOnly("org.springframework.boot:spring-boot-starter")
    compileOnly(project(":server"))
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
