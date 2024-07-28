package tax.bilibili.nineblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan

@EnableCaching
@ConfigurationPropertiesScan
@SpringBootApplication
@ComponentScan(basePackages = ["tax.bilibili.nineblog.application", "tax.bilibili.nineblog.view"])
open class NineBlogApplication

//@SpringBootApplication
//@ComponentScan(basePackages = ["tax.bilibili.nineblog.initialize"])
//open class NineBlogInitializeApplication

object AA {
    lateinit var s : ConfigurableApplicationContext
}

fun main(args: Array<String>) {
    AA.s = runApplication<NineBlogApplication>(*args)
}

