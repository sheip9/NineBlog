package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tax.bilibili.nineblog.application.constant.IdType
import tax.bilibili.nineblog.application.entity.NavItem

@Repository
interface NavItemRepository : R2dbcRepository<NavItem, IdType> {
    fun findNavItemByOrderByPriority(): Flux<NavItem>
}