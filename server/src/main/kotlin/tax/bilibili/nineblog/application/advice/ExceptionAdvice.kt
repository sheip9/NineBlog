package tax.bilibili.nineblog.application.advice

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.exception.BizException
import tax.bilibili.nineblog.application.exception.ClientException

@RestControllerAdvice
@Suppress("ReactiveStreamsUnusedPublisher")
class ExceptionAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RuntimeException::class)
    @ResponseBody
    fun handleExceptionToRestResponse(e: RuntimeException, exchange: ServerWebExchange): Any {
        val responseAnnotation = e.javaClass.getAnnotation(ResponseStatus::class.java)
        val status = responseAnnotation?.value ?: HttpStatus.INTERNAL_SERVER_ERROR
        if (responseAnnotation?.reason?.isNotEmpty() == true) {
            "${responseAnnotation.reason} : ${e.message}"
        } else {
            e.message ?: ""
        }
        exchange.response.statusCode = status
        Thread().run {
            if (e is ClientException || e is BizException) {
                return@run
            }
            e.printStackTrace()
        }
        return Mono.just(e)
    }

    override fun handleHandlerMethodValidationException(
        ex: HandlerMethodValidationException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        exchange: ServerWebExchange,
    ): Mono<ResponseEntity<Any>> {
//        ex.parameterValidationResults.first().resolvableErrors.first().defaultMessage
        val res = ex.parameterValidationResults.joinToString(", ") {
            it.resolvableErrors.joinToString(", ") { err ->
                err.defaultMessage ?: ""
            }
        }
        return Mono.just(ResponseEntity.status(status).body(res))
    }

}