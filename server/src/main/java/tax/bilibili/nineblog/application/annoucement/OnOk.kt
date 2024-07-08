package tax.bilibili.nineblog.application.annoucement

import org.springframework.http.HttpStatus

annotation class OnOk(val code: HttpStatus = HttpStatus.OK, val message: String = "成功")
