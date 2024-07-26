package tax.bilibili.nineblog.application.service.impl

import org.springframework.stereotype.Service
import tax.bilibili.nineblog.application.entity.NavItem
import tax.bilibili.nineblog.application.repository.NavItemRepository
import tax.bilibili.nineblog.application.service.AbstractService

@Service
class NavItemService : AbstractService<NavItemRepository, NavItem, Number>() {
}