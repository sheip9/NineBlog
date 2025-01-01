package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import java.time.ZonedDateTime

//@Table(value = "#{@dataSource.tablePrefix}article")
data class Article(
    @Id
    val id: Number? = 0,
    val authorId: Number,
    var title: String,
    var content: String,
    val createdAt: ZonedDateTime,
    var updatedAt: ZonedDateTime,
    var visibilityLevel: Number,
)
