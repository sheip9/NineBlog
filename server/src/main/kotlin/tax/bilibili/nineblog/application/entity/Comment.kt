package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import tax.bilibili.nineblog.application.constant.IdType
import java.time.ZonedDateTime

data class Comment(
    @Id
    val id: IdType? = 0,
    val articleId: IdType,
    val replyTo: IdType?,
    val nickname: String?,
    val email: String?,
    val content: String,
    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    var auditAt: ZonedDateTime?,
)
