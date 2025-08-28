package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.EntityId

data class ArticleVo(
    val id: EntityId?,
    val authorId: EntityId,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Number,
)