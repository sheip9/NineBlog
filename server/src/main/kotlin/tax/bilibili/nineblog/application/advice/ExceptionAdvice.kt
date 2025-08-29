package tax.bilibili.nineblog.application.advice

import org.springframework.http.*
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.method.annotation.HandlerMethodValidationException
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@ControllerAdvice
@Suppress("ReactiveStreamsUnusedPublisher")
class ExceptionAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RuntimeException::class)
    @ResponseBody
    fun handleExceptionToRestResponse(e: RuntimeException, exchange: ServerWebExchange): Mono<ProblemDetail> =
        Mono.fromCallable {
            val responseAnnotation = e.javaClass.getAnnotation(ResponseStatus::class.java)
            val status = responseAnnotation?.value ?: HttpStatus.INTERNAL_SERVER_ERROR
            val msg = if (responseAnnotation?.reason?.isNotEmpty() == true) {
                "${responseAnnotation.reason} : ${e.message}"
            } else {
                e.message ?: ""
            }

            val detail = ProblemDetail.forStatus(status).apply {
                title = msg
            }
            return@fromCallable detail
        }.subscribeOn(Schedulers.boundedElastic())


    override fun handleHandlerMethodValidationException(
        ex: HandlerMethodValidationException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        exchange: ServerWebExchange,
    ): Mono<ResponseEntity<Any>> = Mono.fromCallable<ResponseEntity<Any>> {
//        ex.parameterValidationResults.first().resolvableErrors.first().defaultMessage
        val messages = ex.parameterValidationResults.joinToString(", ") {
            it.resolvableErrors.joinToString(", ") { err ->
                err.defaultMessage ?: ""
            }
        }
        val detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, messages)
        return@fromCallable ResponseEntity.status(status).body(detail)
    }.subscribeOn(Schedulers.boundedElastic())

}