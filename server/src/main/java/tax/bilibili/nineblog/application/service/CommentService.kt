package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.mapper.CommentMapper
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.repository.CommentRepository

@Service
class CommentService @Autowired constructor(
    val commentMapper: CommentMapper,
) : AbstractService<CommentRepository, Comment, Number>() {

    fun findByArticleId(articleId: Number) = repository.findAllByArticleId(articleId)

    fun save(commentDto: CommentDTO): Mono<Number> {
        val comment = commentMapper.dtoToEntity(commentDto)
        return repository.save(comment).map {
            return@map it.id!!
        }
    }
}