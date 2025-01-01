package tax.bilibili.nineblog.application.mapper

import org.mapstruct.Mapper
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO

@Mapper
interface CommentMapper : BaseMapper<CommentDTO, Comment, Any>