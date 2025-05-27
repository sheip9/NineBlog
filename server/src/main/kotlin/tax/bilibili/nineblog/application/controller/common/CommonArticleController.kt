package tax.bilibili.nineblog.application.controller.common

import jakarta.validation.constraints.Min
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.constant.ObjectId
import tax.bilibili.nineblog.application.service.ArticleService

@RestController
@CommonApi
@RequestMapping("/articles")
class CommonArticleController @Autowired constructor(private val service: ArticleService) {
    @GetMapping("/page")
    fun getArticles(@RequestParam page: Int = 1, @RequestParam @Min(1, message = "wdnm") limit: Int) = service.queryAll(page, limit)

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: ObjectId) = service.queryById(id)

    @GetMapping("/count")
    fun getCount() = service.count()
}