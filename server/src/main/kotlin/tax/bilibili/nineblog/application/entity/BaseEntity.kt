package tax.bilibili.nineblog.application.entity

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import tax.bilibili.nineblog.application.constant.ObjectId
import java.time.ZonedDateTime

@Entity
interface BaseEntity {
    @get:Id
    @get:jakarta.persistence.Id
    val id: ObjectId
    val createdAt: ZonedDateTime
    val updatedAt: ZonedDateTime
}