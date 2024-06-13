package tax.bilibili.nineblog.annoucement

import org.springframework.http.HttpStatus

annotation class OnOk(val code: HttpStatus = HttpStatus.OK, val message: String = "成功")
