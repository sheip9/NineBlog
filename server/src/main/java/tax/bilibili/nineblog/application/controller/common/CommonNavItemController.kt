package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.service.impl.NavItemService

@RestController
@CommonApi
@RequestMapping("/nav-items")
class CommonNavItemController @Autowired constructor(
    private val service: NavItemService
){
    @GetMapping
    fun getNavItems() = service.queryAll()
}