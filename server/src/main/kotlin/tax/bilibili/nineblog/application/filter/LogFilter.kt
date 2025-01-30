package tax.bilibili.nineblog.application.filter

import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.LogInterface

class LogFilter : WebFilter, LogInterface {
    override fun filter(
        exchange: ServerWebExchange,
        chain: WebFilterChain,
    ): Mono<Void?> {
        log.info("Requesting: ${exchange.request.method}  ${exchange.request.path},From IP: ${exchange.request.remoteAddress} ,UA:${exchange.request.headers.get("User-Agent")}")
        return chain.filter(exchange)
    }
}