package tax.bilibili.nineblog.application.model.dataTransfer

import tax.bilibili.nineblog.application.constant.ObjectId

data class ArticleDTO(
    val id: ObjectId?,
    val title: String,
    val content: String,
)
