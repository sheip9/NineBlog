plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinKapt) apply false
    alias(libs.plugins.kotlinKsp) apply false
}

allprojects {
    group = "tax.bilibili"
    version = "0.0.1-SNAPSHOT"
}