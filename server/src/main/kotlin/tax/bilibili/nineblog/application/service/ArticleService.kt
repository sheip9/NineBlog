package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest
import org.springframework.data.relational.core.query.Criteria.where
import org.springframework.data.relational.core.query.Query.query
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.ObjectId
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.mapper.ArticleMapper
import tax.bilibili.nineblog.application.model.dataTransfer.ArticleDTO
import tax.bilibili.nineblog.application.repository.ArticleRepository

@Service
open class ArticleService @Autowired constructor(
    private val articleMapper: ArticleMapper
) : AbstractService<ArticleRepository, Article, ObjectId>() {
    open fun queryAll(page: Int, limit: Int): Flux<Article> {
        return repository.findArticlesByOrderByCreatedAtDesc(PageRequest.of(page, limit))
    }

    fun saveOrUpdate(dto: ArticleDTO): Mono<ObjectId?> {
        val e = articleMapper.dtoToEntity(dto)
        return repository.save(e).map {
            return@map it.id
        }
    }
}