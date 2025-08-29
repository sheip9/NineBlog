package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.mapper.ArticleMapper
import tax.bilibili.nineblog.application.model.dataTransfer.ArticleDTO
import tax.bilibili.nineblog.application.repository.ArticleRepository

@Service
open class ArticleService @Autowired constructor(
    private val articleMapper: ArticleMapper,
) : AbstractService<ArticleRepository, Article, EntityId>() {
    open fun queryAll(page: Int, limit: Int): Flux<Article> {
        return repository.findArticlesByOrderByCreatedAtDesc(PageRequest.of(page, limit))
    }

    open fun save(dto: ArticleDTO): Mono<Article> {
        return super.save(articleMapper.dtoToEntity(dto))
    }

    open fun updateById(id: EntityId, dto: ArticleDTO): Mono<Article> {
        return repository.findById(id).flatMap { article ->
            val res = articleMapper.mergeFromDto(article, dto)
            return@flatMap repository.save(res)
        }
    }

}