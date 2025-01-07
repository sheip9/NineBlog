package tax.bilibili.nineblog.application.mapper

import org.mapstruct.Mapper
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.model.view.CommentVo

@Mapper
interface CommentMapper : BaseMapper<CommentDTO, Comment, CommentVo>