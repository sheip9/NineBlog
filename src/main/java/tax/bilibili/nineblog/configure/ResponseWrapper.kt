package tax.bilibili.nineblog.configure

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.codec.HttpMessageWriter
import org.springframework.web.reactive.HandlerResult
import org.springframework.web.reactive.accept.RequestedContentTypeResolver
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.NineBlog
import tax.bilibili.nineblog.annoucement.OnOk
import tax.bilibili.nineblog.model.RestResponse

class ResponseWrapper(writers: List<HttpMessageWriter<*>?>, resolver: RequestedContentTypeResolver) :
    ResponseBodyResultHandler(
        writers,
        resolver
    ) {

    override fun handleResult(exchange: ServerWebExchange, result: HandlerResult): Mono<Void> {
        exchange.response.headers.add("X-Powered-By", "NineBlog/${NineBlog.VERSION}")
        exchange.response.headers.set("Content-Type", "application/json")

        if(result.returnValue is RestResponse<*>) {
            return writeBody(result.returnValue, result.returnTypeSource, exchange)
        }

        val okAnnotation = result.returnTypeSource.getMethodAnnotation(OnOk::class.java) ?: OnOk()
        exchange.response.statusCode = okAnnotation.code
        val message = okAnnotation.message
        val restfulResult = makeResultRestful(result.returnValue, okAnnotation.code, message)
        return writeBody(restfulResult, result.returnTypeSource, exchange)
    }
    private fun makeResultRestful(result: Any?, code: HttpStatus, message: String): Any {
        fun build(o : Any?): Any {
            if(o is RestResponse<*>) {
                return o
            }
            if(o is String){
                return ObjectMapper().writeValueAsString(RestResponse(code, message, o))
            }
            return RestResponse(code, message, o)
        }
        if (result is Mono<*>) {
            return result
                .map { build(it) }
                .defaultIfEmpty(RestResponse<Any>(code, message))
        }
        if(result is Flux<*>){
            return result
                .collectList()
                .map { build(it) }
                .defaultIfEmpty(RestResponse<Any>(code, message))
        }
        return build(result)
    }
}