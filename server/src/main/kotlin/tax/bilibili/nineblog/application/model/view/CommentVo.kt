package tax.bilibili.nineblog.application.model.view

import tax.bilibili.nineblog.application.constant.ObjectId
import java.time.ZonedDateTime

data class CommentVo(
    val id: ObjectId,
    val replyTo: ObjectId,
    val nickname: String,
    val content: String,
    val createdAt: ZonedDateTime,
)
