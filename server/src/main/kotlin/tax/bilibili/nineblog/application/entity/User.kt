package tax.bilibili.nineblog.application.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import tax.bilibili.nineblog.application.constant.EntityId
import java.time.ZonedDateTime

@Entity
data class User(
    @Id
    override val id: EntityId,
    val username: String,
    val nickname: String,
    val email: String,
    val password: String,
    val salt: String,
    val lastLoginTime: String,
    val registrationTime: String,
    override val createdAt: ZonedDateTime,
    override val updatedAt: ZonedDateTime,
) : BaseEntity
