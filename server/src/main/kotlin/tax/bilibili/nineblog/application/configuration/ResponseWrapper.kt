package tax.bilibili.nineblog.application.configuration

import org.springframework.http.codec.HttpMessageWriter
import org.springframework.web.reactive.HandlerResult
import org.springframework.web.reactive.accept.RequestedContentTypeResolver
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.NineBlog
import tax.bilibili.nineblog.application.advice.ExceptionAdvice
import tax.bilibili.nineblog.application.annoucement.OnOk

@Suppress("UastIncorrectHttpHeaderInspection")
class ResponseWrapper(writers: List<HttpMessageWriter<*>?>, resolver: RequestedContentTypeResolver) :
    ResponseBodyResultHandler(
        writers,
        resolver
    ) {

    override fun handleResult(exchange: ServerWebExchange, result: HandlerResult): Mono<Void> {
        exchange.response.headers.add("X-Powered-By", "NineBlog/${NineBlog.VERSION}")
        exchange.response.headers.set("Content-Type", "application/json")

        if (result.returnTypeSource.executable.declaringClass == ExceptionAdvice::class.java) {
            return writeBody(result.returnValue, result.returnTypeSource, exchange)
        }

        val okAnnotation = result.returnTypeSource.getMethodAnnotation(OnOk::class.java) ?: OnOk()
        exchange.response.statusCode = okAnnotation.code

        return writeBody(result.returnValue, result.returnTypeSource, exchange)
    }
}