package tax.bilibili.nineblog.application.configure

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import tax.bilibili.nineblog.application.property.DataSource

@Configuration
open class R2dbcConfiguration(
    @Autowired val datasource: DataSource,
) : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .option<String>(DRIVER, datasource.driver)
                .option<String>(HOST, datasource.host)
                .option<Int>(PORT, datasource.port)
                .option<String>(USER, datasource.user)
                .option<CharSequence>(PASSWORD, datasource.password)
                .option<String>(DATABASE, datasource.database)
                .build()
        )
    }

}