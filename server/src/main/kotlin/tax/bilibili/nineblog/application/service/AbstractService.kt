package tax.bilibili.nineblog.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.*
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.LogInterface

abstract class AbstractService<R : R2dbcRepository<T, ID>, T, ID> : LogInterface {

    lateinit var repository: R
    @Autowired set

    @Autowired
    lateinit var template: R2dbcEntityTemplate

    inline fun <reified T> select(): ReactiveSelectOperation.ReactiveSelect<T> {
        return template.select<T>(T::class.java)
    }

    inline fun <reified T> insert(): ReactiveInsertOperation.ReactiveInsert<T?> {
        return template.insert<T>(T::class.java)
    }

    inline fun <reified T> update(): ReactiveUpdateOperation.ReactiveUpdate {
        return template.update(T::class.java)
    }

    inline fun <reified T> delete(): ReactiveDeleteOperation.ReactiveDelete {
        return template.delete(T::class.java)
    }

    fun save(entity: T): Mono<T> {
        return repository.save(entity!!)
    }

    fun deleteById(id: ID): Mono<Void> {
        return repository.deleteById(id!!)
    }

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
