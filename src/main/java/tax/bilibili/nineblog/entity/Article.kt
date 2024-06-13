package tax.bilibili.nineblog.entity

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table

@Table("articles")
data class Article(
    @Id(keyType = KeyType.Auto)
    val id: Int,
    val authorId: Int,
    val title: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val visibilityLevel: Int,
)
