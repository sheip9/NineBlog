package tax.bilibili.nineblog.application.controller.admin

import jakarta.validation.constraints.Positive
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tax.bilibili.nineblog.application.annoucement.AdminApi
import tax.bilibili.nineblog.application.annoucement.OnOk
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.model.dataTransfer.ArticleDTO
import tax.bilibili.nineblog.application.service.ArticleService

@RestController
@AdminApi
@RequestMapping("/admin/articles")
class AdminArticleController @Autowired constructor(
    private val articleService: ArticleService
) {
    @PostMapping
    @OnOk(code = HttpStatus.CREATED)
    fun createArticle(@RequestBody @Validated article: ArticleDTO) = articleService.save(article)


    @PatchMapping("/{id}")
    fun updateArticle(@PathVariable("id") @Positive id: EntityId, @RequestBody @Validated article: ArticleDTO) = articleService.updateById(id,article)
}