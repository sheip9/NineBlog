package tax.bilibili.nineblog.application.entity

import jakarta.persistence.Entity
import tax.bilibili.nineblog.application.constant.EntityId
import java.time.ZonedDateTime

@Entity
data class Article(
    @jakarta.persistence.Id
    override val id: EntityId,
    var authorId: EntityId,
    var title: String,
    var content: String,
    var visibilityLevel: Int,
    override val createdAt: ZonedDateTime,
    override val updatedAt: ZonedDateTime,
) : BaseEntity
