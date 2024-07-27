package tax.bilibili.nineblog.view.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("#")
interface IViewController {
    @GetMapping
    fun toHomePage() : String
}