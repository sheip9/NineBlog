package tax.bilibili.nineblog.application.configure

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.HandlerTypePredicate
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.PathMatchConfigurer
import org.springframework.web.reactive.config.WebFluxConfigurer
import tax.bilibili.nineblog.application.annoucement.CommonApi

@Configuration
@EnableWebFlux
open class WebConfig : WebFluxConfigurer {
    override fun configurePathMatching(configurer: PathMatchConfigurer) {
        configurer.addPathPrefix(
            "/api/common", HandlerTypePredicate.forAnnotation(CommonApi::class.java)
        )
        configurer.addPathPrefix(
            "/api", HandlerTypePredicate.forAnnotation(RestController::class.java)
        )

    }
}