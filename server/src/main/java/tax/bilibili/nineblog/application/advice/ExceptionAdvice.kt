package tax.bilibili.nineblog.application.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.exception.BusinessException
import tax.bilibili.nineblog.application.exception.ClientException

@RestControllerAdvice
@Suppress("ReactiveStreamsUnusedPublisher")
class ExceptionAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(RuntimeException::class)
    @ResponseBody
    fun handleExceptionToRestResponse(e: RuntimeException, exchange: ServerWebExchange): Any {
        val responseAnnotation = e.javaClass.getAnnotation(ResponseStatus::class.java)
        val status = responseAnnotation?.value ?: HttpStatus.INTERNAL_SERVER_ERROR
        val message = if (responseAnnotation?.reason?.isNotEmpty() == true) {
            "${responseAnnotation.reason} : ${e.message}"
        } else {
            e.message ?: ""
        }
        exchange.response.statusCode = status
        Thread().run {
            if (e is ClientException || e is BusinessException) {
                return@run
            }
            e.printStackTrace()
        }
        return Mono.just(e)
    }

//    override fun handleMethodArgumentNotValid(
//        ex: MethodArgumentNotValidException,
//        headers: HttpHeaders,
//        status: HttpStatusCode,
//        request: WebRequest
//    ): ResponseEntity<Any> {
//        return ResponseEntity("Validation failed: " + ex.bindingResult.toString(), HttpStatus.BAD_REQUEST)
//    }
}