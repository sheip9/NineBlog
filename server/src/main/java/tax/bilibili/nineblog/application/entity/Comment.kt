package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id
import java.time.ZonedDateTime

data class Comment(
    @Id
    val id: Long? = 0,
    var articleId: Number,
    var replyTo: Number?,
    var userId: Number?,
    var nickname: String?,
    var email: String,
    var content: String,
    var createdAt: String?,
    var auditAt: ZonedDateTime?,
)
