package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id

//@Table(value = "#{@dataSource.tablePrefix}article")
data class Article(
    @Id
    val id: Number?,
    val authorId: Number,
    val title: String,
    val content: String,
    val createdAt: String?,
    val updatedAt: String?,
    val visibilityLevel: Number,
)
