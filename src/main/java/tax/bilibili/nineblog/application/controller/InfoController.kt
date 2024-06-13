package tax.bilibili.nineblog.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.annoucement.OnOk
import tax.bilibili.nineblog.application.exception.LoginException

@RequestMapping("/aaa")
@RestController
class InfoController {
    @GetMapping
    @OnOk()
    fun hello(): Nothing = throw LoginException()
}
