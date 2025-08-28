package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.EntityId
import java.time.ZonedDateTime

data class CommentVo(
    val id: EntityId,
    val replyTo: EntityId,
    val nickname: String,
    val content: String,
    val createdAt: ZonedDateTime,
)
