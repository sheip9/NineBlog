import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagerment)
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinKapt)
//    alias(libs.plugins.kotlinKsp)
    application
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

repositories {
    mavenCentral()
}

dependencies {
    //kotlin base
    implementation(kotlin("stdlib-jdk8"))
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.2.20")
    //spring framework
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.hibernate.tool:hibernate-tools-orm:7.1.0.Final")
    //sa-token https://sa-token.cc
    implementation("cn.dev33:sa-token-reactor-spring-boot3-starter:1.44.0")
    //mapstruct
    implementation ("org.mapstruct:mapstruct:1.6.3")
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-annotations:1.1.3")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")
    kapt("org.mapstruct.extensions.spring:mapstruct-spring-annotations:1.1.3")
    //sql drive https://r2dbc.io/drivers/
    runtimeOnly("com.oracle.database.r2dbc:oracle-r2dbc:1.3.0")
    runtimeOnly("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
    runtimeOnly("org.mariadb:r2dbc-mariadb:1.3.0")
    runtimeOnly("io.r2dbc:r2dbc-mssql:1.0.2.RELEASE")
    runtimeOnly("io.asyncer:r2dbc-mysql:1.4.1")
    runtimeOnly("org.postgresql:r2dbc-postgresql:1.0.7.RELEASE")
    //testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

//ksp {
//    arg("mapstruct.defaultComponentModel", "spring")
//    arg("mapstruct.unmappedTargetPolicy", "IGNORE")
//}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "IGNORE")
    }
}

tasks.withType<JavaCompile>().configureEach {
//    listOf(
//    ).forEach(options.compilerArgs::add)
}

tasks.named<BootJar>("bootJar") {
    manifest {
        attributes["Implementation-Version"] = version
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}