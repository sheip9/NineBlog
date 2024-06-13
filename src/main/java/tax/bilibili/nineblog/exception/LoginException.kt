package tax.bilibili.nineblog.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "登录账号信息错误")
class LoginException : RuntimeException()