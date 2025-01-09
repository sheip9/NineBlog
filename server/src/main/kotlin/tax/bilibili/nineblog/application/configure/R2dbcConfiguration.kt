package tax.bilibili.nineblog.application.configure

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import tax.bilibili.nineblog.application.property.DatasourceProperty

@Configuration
open class R2dbcConfiguration(
    @Autowired val datasource: DatasourceProperty,
) : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            builder()
                .option(DRIVER, "pool")
                .option(HOST, datasource.host)
                .option(PORT, datasource.port)
                .option(USER, datasource.user)
                .option(PASSWORD, datasource.password)
                .option(DATABASE, datasource.database)
                .option(PROTOCOL, datasource.driver)
                .build()
        )
    }
}