package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.IdType
import java.time.ZonedDateTime

data class CommentVo(
    val id: IdType,
    val replyTo: IdType,
    val nickname: String,
    val content: String,
    val createdAt: ZonedDateTime,
)
