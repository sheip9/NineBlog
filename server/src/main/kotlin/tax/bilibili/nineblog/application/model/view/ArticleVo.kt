package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.ObjectId

data class ArticleVo(
    val id: ObjectId?,
    val authorId: ObjectId,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Number,
)