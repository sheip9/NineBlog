package tax.bilibili.nineblog.initializer.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.property.DatabaseDriver
import tax.bilibili.nineblog.initializer.model.DatasourceModel
import tax.bilibili.nineblog.initializer.service.InitializerService

/**
 * InitializerController
 *
 */
@RestController
class InitializerController @Autowired constructor(
    val service: InitializerService
){
    @PostMapping
    fun postDatasourceProperty(@RequestBody x: DatasourceModel): Any {
        println(ObjectMapper().writeValueAsString(x))
        return service.saveDatasource(x.toProperty())
    }

    @RequestMapping("/drives")
    fun drives(): Any {
        return Mono.just(DatabaseDriver.entries)
    }

    @RequestMapping("/check_connection")
    fun checkConnection(): Any {
        return service.checkConnection()
    }
}