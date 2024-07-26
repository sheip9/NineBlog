package tax.bilibili.nineblog.application.controller.admin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.annoucement.AdminApi
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.service.impl.ArticleService

@RestController
@AdminApi
@RequestMapping("/admin/articles")
class AdminArticleController @Autowired constructor(
    private val articleService: ArticleService
){
    @PostMapping
    fun createArticle(@RequestBody article: Article): Mono<*> = articleService.save(article)

}