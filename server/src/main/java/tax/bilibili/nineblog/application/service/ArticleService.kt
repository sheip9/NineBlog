package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.mapper.ArticleMapper
import tax.bilibili.nineblog.application.model.dataTransfer.ArticleDTO
import tax.bilibili.nineblog.application.repository.ArticleRepository

@Service
class ArticleService @Autowired constructor(
    val articleMapper: ArticleMapper
) : AbstractService<ArticleRepository, Article, Number>() {
    fun queryAll(page: Number, limit: Number) = repository.findAll(limit, (limit.toInt() - 1) * page.toInt())

    fun saveOrUpdate(dto: ArticleDTO): Mono<Number?> {
        val e = articleMapper.dtoToEntity(dto)
        return repository.save(e).map {
            return@map it.id!!
        }
    }
}