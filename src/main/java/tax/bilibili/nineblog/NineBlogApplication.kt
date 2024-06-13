package tax.bilibili.nineblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class NineBlogApplication

fun main(args: Array<String>) {

    runApplication<NineBlogApplication>(*args)
}

