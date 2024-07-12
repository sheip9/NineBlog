package tax.bilibili.nineblog.application.entity

data class Comment(
    val id: Int,
    val userId: Int,
    val email: String,
    val content: String,
    val createdAt: String,
)
