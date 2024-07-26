package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.annoucement.OnOk
import tax.bilibili.nineblog.application.service.impl.ArticleService

@RestController
@CommonApi
@RequestMapping("/articles")
class CommonArticleController @Autowired constructor(private val service: ArticleService) {
    @GetMapping("/page")
    @OnOk(message = "成功查询文章列表")
    fun getArticles(@RequestParam page: Number = 1, @RequestParam limit: Number = 10) = service.queryAll(page, limit)

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Number) = service.queryById(id)

    @GetMapping("/count")
    fun getCount() = service.count()
}