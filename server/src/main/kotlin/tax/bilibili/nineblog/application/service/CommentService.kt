package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.mapper.CommentMapper
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.repository.CommentRepository

@Service
class CommentService @Autowired constructor(
    val commentMapper: CommentMapper,
) : AbstractService<CommentRepository, Comment, EntityId>() {

    fun findByArticleId(articleId: EntityId, page: Int, limit: Int) = repository.findAllByArticleId(articleId, PageRequest.of(page, limit))

    fun save(commentDto: CommentDTO): Mono<Comment> {
        val comment = commentMapper.dtoToEntity(commentDto)
        return super.save(comment)
    }

    fun countCommentByArticleId(articleId: EntityId): Mono<Long> = repository.countCommentByArticleId(articleId)

}