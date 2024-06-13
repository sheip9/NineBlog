package tax.bilibili.nineblog.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.annoucement.OnOk
import tax.bilibili.nineblog.exception.LoginException

@RequestMapping("/aaa")
@RestController
class InfoController {
    @GetMapping
    @OnOk()
    fun hello(): Nothing = throw LoginException()
}
