package tax.bilibili.nineblog.application.controller.common

import jakarta.validation.constraints.Positive
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.service.ArticleService

@RestController
@CommonApi
@RequestMapping("/articles")
class CommonArticleController @Autowired constructor(private val service: ArticleService) {
    @GetMapping
    fun getArticles(@RequestParam @Positive(message = "{common.articles.getArticles.page.Min}") page: Int = 1, @RequestParam @Positive(message = "{common.articles.getArticles.limit.Positive}") limit: Int = 10) = service.queryAll(page, limit)

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable @Positive(message = "{common.articles.getArticleById.id.Positive}") id: EntityId) = service.queryById(id)

    @GetMapping("/count")
    fun getCount() = service.count()
}