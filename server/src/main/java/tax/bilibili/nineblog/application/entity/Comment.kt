package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import tax.bilibili.nineblog.application.constant.IdType
import java.time.ZonedDateTime

data class Comment(
    @Id
    val id: IdType? = 0,
    var articleId: IdType,
    var replyTo: IdType?,
    var userId: IdType?,
    var nickname: String?,
    var email: String,
    var content: String,
    var createdAt: String?,
    var auditAt: ZonedDateTime?,
)
