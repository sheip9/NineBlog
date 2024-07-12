package tax.bilibili.nineblog.application.model

import reactor.core.publisher.Flux

data class PagedData<T>(
    val data: Flux<T>,
    val page: Int,
    val size: Int,
)
