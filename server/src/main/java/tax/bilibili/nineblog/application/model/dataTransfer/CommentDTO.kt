package tax.bilibili.nineblog.application.model.dataTransfer

import jakarta.validation.constraints.NotEmpty

data class CommentDTO(
    @NotEmpty
    val articleId: Number,
    @NotEmpty
    val email: String,
    @NotEmpty
    val content: String,
)
