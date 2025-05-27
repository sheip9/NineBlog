package tax.bilibili.nineblog.application.entity

import jakarta.persistence.Entity
import tax.bilibili.nineblog.application.constant.ObjectId
import java.time.ZonedDateTime

@Entity
data class Comment(
    @get:jakarta.persistence.Id
    override val id: ObjectId,
    val articleId: ObjectId,
    val replyTo: ObjectId?,
    val nickname: String?,
    val email: String?,
    val content: String,
    var auditAt: ZonedDateTime?,
    override val createdAt: ZonedDateTime,
    override val updatedAt: ZonedDateTime,
) : BaseEntity
