import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackCssRule

plugins {
    id("org.jetbrains.kotlin.multiplatform") version "2.0.0"
}

group = "tax.bilibili.nineblog"
version = "unspecified"

repositories {
    mavenCentral()
}
kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport{
                    enabled.set(true)
                }
                devServer = KotlinWebpackConfig.DevServer(
                    static = mutableListOf("$layout.buildDirectory/distributions"),
                    // proxy api calls to springboot running on 3000 configured in application.yml
                    proxy = hashMapOf("/api" to "http://localhost:3000")
                )
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(npm("react", "18.2.0"))
            }
        }
    }
}
