package tax.bilibili.nineblog.application.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.mapper.CommentMapper
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.repository.CommentRepository

@Service
class CommentService : AbstractService<CommentRepository, Comment, Number>() {

    private val mapper = CommentMapper.INSTANCE

    fun findByArticleId(articleId: Number) = repository.findAllByArticleId(articleId)

    fun saveComment(commentDto : CommentDTO): Mono<*> {
        val comment = mapper.commentDtoToComment(commentDto)
        return repository.save(comment)
    }
}