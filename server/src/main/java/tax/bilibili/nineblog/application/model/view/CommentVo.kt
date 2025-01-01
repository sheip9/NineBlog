package tax.bilibili.nineblog.application.model.view

import java.time.ZonedDateTime

data class CommentVo(
    val id: Long,
    val replyTo: Number?,
    val nickname: String,
    val content: String,
    val createdAt: ZonedDateTime,
)
