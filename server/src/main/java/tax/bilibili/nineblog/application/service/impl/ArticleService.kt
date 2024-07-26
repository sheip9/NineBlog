package tax.bilibili.nineblog.application.service.impl

import org.springframework.stereotype.Service
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.repository.ArticleRepository
import tax.bilibili.nineblog.application.service.AbstractService

@Service
class ArticleService : AbstractService<ArticleRepository, Article, Number>() {
    fun queryAll(page: Number, limit: Number) = repository.findAll(limit, (limit.toInt() - 1) * page.toInt())
}