package tax.bilibili.nineblog.application.mapper

import org.mapstruct.Mapper
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.model.dataTransfer.ArticleDTO
import tax.bilibili.nineblog.application.model.view.ArticleVo

@Mapper
interface ArticleMapper: BaseMapper<ArticleDTO, Article, ArticleVo>