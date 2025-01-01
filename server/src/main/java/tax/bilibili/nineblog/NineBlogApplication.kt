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
    //TODO: 判断程序配置是否初始化
    if (true) {
        runApplication<NineBlogApplication>(*args)
    } else {
        runApplication<NineBlogInitializeApplication>(*args)
    }
}

