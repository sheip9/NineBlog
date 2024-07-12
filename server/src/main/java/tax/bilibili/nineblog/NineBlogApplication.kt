package tax.bilibili.nineblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan

@EnableCaching
@ConfigurationPropertiesScan
@SpringBootApplication
@ComponentScan(basePackages = ["tax.bilibili.nineblog.application"])
open class NineBlogApplication

@SpringBootApplication
@ComponentScan(basePackages = ["tax.bilibili.nineblog.initialize"])
open class NineBlogInitializeApplication

fun main(args: Array<String>) {
    runApplication<NineBlogApplication>(*args)
}

