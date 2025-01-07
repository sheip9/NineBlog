package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class AbstractService<R : R2dbcRepository<T, ID>, T, ID> {
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    lateinit var repository: R

    @Autowired
    lateinit var template: R2dbcEntityTemplate

    fun save(entity: T): Mono<T> {
        return repository.save(entity!!)
    }

    fun deleteById(id: ID): Mono<Void> {
        return repository.deleteById(id!!)
    }

//    fun update(id: ID, entity: T): Mono<T> {
//        return repository.
//    }

    open fun queryAll(): Flux<T> {
        return repository.findAll()
    }

    fun queryById(id: ID): Mono<T> {
        return repository.findById(id!!)
    }

    fun count(): Mono<Long> {
        return repository.count()
    }
}
