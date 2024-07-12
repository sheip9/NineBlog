package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id


data class Article(
    @Id
    val id: Int?,
    val authorId: Int,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Int,
)
