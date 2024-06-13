package tax.bilibili.nineblog.entity

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table

@Table("comments")
data class Comment(
    @Id(keyType = KeyType.Auto)
    val id: Int,
    val userId: Int,
    val email: String,
    val content: String,
    val createdAt: String,
)
