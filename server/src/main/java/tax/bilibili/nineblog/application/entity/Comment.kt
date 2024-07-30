package tax.bilibili.nineblog.application.entity

data class Comment(
    val id: Number,
    val articleId: Number,
    val userId: Number,
    val email: String,
    val content: String,
    val createdAt: String,
    val isAudits: Boolean
)
