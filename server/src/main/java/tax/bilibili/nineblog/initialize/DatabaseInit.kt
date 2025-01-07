package tax.bilibili.nineblog.initialize

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactoryOptions.DATABASE
import io.r2dbc.spi.ConnectionFactoryOptions.DRIVER
import io.r2dbc.spi.ConnectionFactoryOptions.HOST
import io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD
import io.r2dbc.spi.ConnectionFactoryOptions.PORT
import io.r2dbc.spi.ConnectionFactoryOptions.USER
import io.r2dbc.spi.ConnectionFactoryOptions.builder
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.property.DataSource
import tax.bilibili.nineblog.application.property.DatabaseType.*

@Service
class DatabaseInit  {
    fun createTables(datasource: DataSource): Mono<Void> {
        var c = ConnectionFactories.get(
            builder()
                .option(DRIVER, "mysql")
                .option(HOST, datasource.host)
                .option(PORT, datasource.port)
                .option(USER, datasource.user)
                .option(PASSWORD, datasource.password)
                .option(DATABASE, datasource.database)
                .build()
        )

        var cdp = CompositeDatabasePopulator()
        cdp.addPopulators(ResourceDatabasePopulator(ClassPathResource("initializer/table_creating.sql")))
        when(datasource.type) {
            MYSQL -> cdp.addPopulators(ResourceDatabasePopulator(ClassPathResource("initializer/mysql.sql")))
            POSTGRES -> cdp.addPopulators(ResourceDatabasePopulator(ClassPathResource("initializer/postgres.sql")))
            MSSQL -> null
            H2DB -> null
            else -> null
        }
        return cdp.populate(c)
    }

}