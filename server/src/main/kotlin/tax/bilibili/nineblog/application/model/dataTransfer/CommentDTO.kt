package tax.bilibili.nineblog.application.model.dataTransfer

import jakarta.validation.constraints.NotEmpty
import tax.bilibili.nineblog.application.constant.EntityId

data class CommentDTO(
    @NotEmpty
    val articleId: EntityId,
    val replyTo: EntityId?,
    @NotEmpty
    val nickname: String,
    @NotEmpty
    val email: String,
    @NotEmpty
    val content: String
)
