package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import tax.bilibili.nineblog.application.constant.IdType
import java.time.ZonedDateTime

//@Table(value = "#{@dataSource.tablePrefix}article")
data class Article (
    @Id
    val id: IdType? = 0,
    val authorId: IdType,
    var title: String,
    var content: String,
    val createdAt: ZonedDateTime,
    var updatedAt: ZonedDateTime,
    var visibilityLevel: Int,
)
