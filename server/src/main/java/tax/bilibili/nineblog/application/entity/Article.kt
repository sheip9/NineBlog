package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import java.time.ZonedDateTime
import java.util.Date

//@Table(value = "#{@dataSource.tablePrefix}article")
data class Article(
    @Id
    val id: Number?,
    val authorId: Number,
    val title: String,
    val content: String,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
    val visibilityLevel: Number,
)
