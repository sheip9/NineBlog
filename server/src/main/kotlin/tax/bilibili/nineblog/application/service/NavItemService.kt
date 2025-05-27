package tax.bilibili.nineblog.application.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import tax.bilibili.nineblog.application.constant.ObjectId
import tax.bilibili.nineblog.application.entity.NavItem
import tax.bilibili.nineblog.application.repository.NavItemRepository

@Service
class NavItemService : AbstractService<NavItemRepository, NavItem, ObjectId>() {
    override fun queryAll(): Flux<NavItem> = repository.findNavItemByOrderByPriority()
}