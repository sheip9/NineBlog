package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import tax.bilibili.nineblog.application.entity.Article

@Repository
interface ArticleRepository : R2dbcRepository<Article, Number> {
}