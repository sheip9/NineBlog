package tax.bilibili.nineblog.application.annoucement

import org.springframework.http.HttpStatus

@Retention(AnnotationRetention.RUNTIME)
annotation class OnOk(val code: HttpStatus = HttpStatus.OK)
