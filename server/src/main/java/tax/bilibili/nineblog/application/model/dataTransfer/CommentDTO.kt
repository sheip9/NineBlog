package tax.bilibili.nineblog.application.model.dataTransfer

import jakarta.validation.constraints.NotEmpty

data class CommentDTO(
    @NotEmpty
    val articleId: Number,
    val replyTo: Number?,
    @NotEmpty
    val nickname: String,
    @NotEmpty
    val email: String,
    @NotEmpty
    val content: String,
)
