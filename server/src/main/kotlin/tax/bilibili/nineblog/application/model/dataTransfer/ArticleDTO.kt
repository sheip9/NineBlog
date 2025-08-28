package tax.bilibili.nineblog.application.model.dataTransfer

import jakarta.validation.constraints.NotEmpty
import tax.bilibili.nineblog.application.constant.EntityId

data class ArticleDTO(
    val authorId: EntityId,
    @param:NotEmpty(message = "{ArticleDTO.title.NotEmpty}")
    val title: String,
    val content: String,
    val visibilityLevel: Int,
)
