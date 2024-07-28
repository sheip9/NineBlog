package tax.bilibili.nineblog.application.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.model.RestResponse
import tax.bilibili.nineblog.application.service.impl.ArticleService
import tax.bilibili.nineblog.view.service.ViewService

@RestController
@RequestMapping("/test")
class TestController {
    @Autowired
    lateinit var articleService: ArticleService

    @Autowired
    lateinit var viewService: ViewService

    // Used for wrapping response to RESTFul
    val mapper: (Any) -> Mono<Any> = { it: Any -> Mono.just(RestResponse(200, "success", it)) }

    @GetMapping
    fun test() = viewService.loadViewComponent()

    @GetMapping("/a")
    fun getArticles() = articleService.queryAll()

    @GetMapping("/b")
    fun getArticles2() = articleService.queryAll()
        .collectList()
    //  .flatMap(mapper)
    // If without collectList(), cant warp response
    @GetMapping("/c")
    fun aa() = ResponseEntity("1", HttpStatus.LOCKED)
}