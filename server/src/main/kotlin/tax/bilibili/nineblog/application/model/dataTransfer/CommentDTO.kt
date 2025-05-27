package tax.bilibili.nineblog.application.model.dataTransfer

import jakarta.validation.constraints.NotEmpty
import tax.bilibili.nineblog.application.constant.ObjectId

data class CommentDTO(
    @NotEmpty
    val articleId: ObjectId,
    val replyTo: ObjectId?,
    @NotEmpty
    val nickname: String,
    @NotEmpty
    val email: String,
    @NotEmpty
    val content: String,
)
