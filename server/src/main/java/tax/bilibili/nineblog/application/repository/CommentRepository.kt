package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import tax.bilibili.nineblog.application.entity.Comment

interface CommentRepository : R2dbcRepository<Comment, Number> {

    fun findAllByArticleId(articleId: Number): Flux<Comment>
}