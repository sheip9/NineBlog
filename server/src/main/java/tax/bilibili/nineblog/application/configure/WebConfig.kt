package tax.bilibili.nineblog.application.configure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.HandlerTypePredicate
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.PathMatchConfigurer
import org.springframework.web.reactive.config.ViewResolverRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.thymeleaf.spring6.view.reactive.ThymeleafReactiveViewResolver
import tax.bilibili.nineblog.application.annoucement.CommonApi


@Configuration
@EnableWebFlux
open class WebConfig @Autowired constructor(
    private val thymeleafReactiveViewResolver: ThymeleafReactiveViewResolver
) : WebFluxConfigurer {
    override fun configurePathMatching(configurer: PathMatchConfigurer) {
        configurer.addPathPrefix(
            "/api/common", HandlerTypePredicate.forAnnotation(CommonApi::class.java)
        )
        configurer.addPathPrefix(
            "/api", HandlerTypePredicate.forAnnotation(RestController::class.java)
        )

    }

    /**
     * 加入thymeleaf试图解析器，不然找不到view name
     *
     * @param registry
     */
    override fun configureViewResolvers(registry: ViewResolverRegistry) {
        registry.viewResolver(thymeleafReactiveViewResolver)
    }
}