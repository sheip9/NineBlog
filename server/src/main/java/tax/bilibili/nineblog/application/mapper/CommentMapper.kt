package tax.bilibili.nineblog.application.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO

@Mapper
interface CommentMapper {
    companion object {
        val INSTANCE: CommentMapper = Mappers.getMapper(CommentMapper::class.java)
    }

    fun commentDtoToComment(commentDto: CommentDTO) : Comment
}