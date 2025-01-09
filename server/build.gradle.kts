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
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
    //spring framework
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//    implementation("cn.dev33:sa-token-spring-boot3-starter:1.37.0")
    //mapstruct
    implementation ("org.mapstruct:mapstruct:1.6.3")
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-annotations:1.1.2")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")
    kapt("org.mapstruct.extensions.spring:mapstruct-spring-annotations:1.1.2")
    //sql drive https://r2dbc.io/drivers/
    runtimeOnly("com.oracle.database.r2dbc:oracle-r2dbc:1.3.0")
    runtimeOnly("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
    runtimeOnly("org.mariadb:r2dbc-mariadb:1.3.0")
    runtimeOnly("io.r2dbc:r2dbc-mssql:1.0.0.RELEASE")
    runtimeOnly("io.asyncer:r2dbc-mysql:1.1.0")
    runtimeOnly("org.postgresql:r2dbc-postgresql:1.0.5.RELEASE")
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

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}