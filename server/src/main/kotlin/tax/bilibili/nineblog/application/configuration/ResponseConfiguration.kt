package tax.bilibili.nineblog.application.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.web.reactive.accept.RequestedContentTypeResolver

@Configuration
open class ResponseConfiguration {
    @Bean
    open fun responseWrapper(
        serverCodecConfigurer: ServerCodecConfigurer,
        requestedContentTypeResolver: RequestedContentTypeResolver
    ): ResponseWrapper {
        return ResponseWrapper(serverCodecConfigurer.writers, requestedContentTypeResolver)
    }
}