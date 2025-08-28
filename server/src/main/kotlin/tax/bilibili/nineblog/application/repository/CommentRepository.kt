package tax.bilibili.nineblog.application.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.entity.Comment

interface CommentRepository : R2dbcRepository<Comment, EntityId> {

    fun findAllByArticleId(articleId: Number, pageable: Pageable): Flux<Comment>

    fun countCommentByArticleId(articleId: Number): Mono<Long>
}