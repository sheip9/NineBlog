package tax.bilibili.nineblog.application.model.view

data class ArticleVo (
    val id: Number?,
    val authorId: Number,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Number,
)