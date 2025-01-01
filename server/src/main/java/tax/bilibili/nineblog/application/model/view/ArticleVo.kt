package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.IdType

data class ArticleVo(
    val id: IdType?,
    val authorId: IdType,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Number,
)