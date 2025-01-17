package tax.bilibili.nineblog.application.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tax.bilibili.nineblog.application.constant.IdType
import tax.bilibili.nineblog.application.entity.Article

@Repository
interface ArticleRepository : R2dbcRepository<Article, IdType> {

    @Query(
        "SELECT id, author_id, title, LEFT(content, 5) AS content, created_at, updated_at, visibility_level" +
                " FROM Article"
    ) // 唉，要是能自动识别实体的表名就好了
    override fun findAll(): Flux<Article>

    fun findArticlesByOrderByCreatedAtDesc(pageable: Pageable): Flux<Article>
}