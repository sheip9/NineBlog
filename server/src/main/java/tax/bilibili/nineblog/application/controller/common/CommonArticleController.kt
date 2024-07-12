package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.OnOk
import tax.bilibili.nineblog.application.model.RestResponse
import tax.bilibili.nineblog.application.service.impl.ArticleService

@RestController
@RequestMapping("/common/articles")
class CommonArticleController @Autowired constructor(private val service: ArticleService) {
    @GetMapping
    @OnOk(message = "成功查询文章列表")
    fun getArticles() = service.queryAll()

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Number) = service.queryById(id)
}