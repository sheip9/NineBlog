plugins {
    java
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagerment)
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinKapt)
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
    //sql drive
    runtimeOnly("io.asyncer:r2dbc-mysql:1.1.0")
    runtimeOnly("org.postgresql:r2dbc-postgresql:1.0.5.RELEASE")
    runtimeOnly("io.r2dbc:r2dbc-mssql:1.0.0.RELEASE")
    //testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

kapt{
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "IGNORE")
    }
}

tasks.withType<JavaCompile>().configureEach {
//    listOf(
//    ).forEach(options.compilerArgs::add)
}

tasks.withType<Test> {
    useJUnitPlatform()
}