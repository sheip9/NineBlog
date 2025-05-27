package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.ObjectId
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.mapper.CommentMapper
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.repository.CommentRepository

@Service
class CommentService @Autowired constructor(
    val commentMapper: CommentMapper,
) : AbstractService<CommentRepository, Comment, ObjectId>() {

    fun findByArticleId(articleId: ObjectId, page: Int, limit: Int) = repository.findAllByArticleId(articleId, PageRequest.of(page, limit))

    fun save(commentDto: CommentDTO): Mono<ObjectId> {
        val comment = commentMapper.dtoToEntity(commentDto)
        return save(comment).map {
            return@map it.id
        }
    }

    fun countCommentByArticleId(articleId: ObjectId): Mono<Long> = repository.countCommentByArticleId(articleId)

}