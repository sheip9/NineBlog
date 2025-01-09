package tax.bilibili.nineblog.initializer.service

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.DATABASE
import io.r2dbc.spi.ConnectionFactoryOptions.DRIVER
import io.r2dbc.spi.ConnectionFactoryOptions.HOST
import io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD
import io.r2dbc.spi.ConnectionFactoryOptions.PORT
import io.r2dbc.spi.ConnectionFactoryOptions.USER
import io.r2dbc.spi.ConnectionFactoryOptions.builder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.property.DatasourceProperty
import tax.bilibili.nineblog.initializer.exception.DatabaseNotInitException
import tax.bilibili.nineblog.initializer.utils.DatabaseInitUtils

@Service
class InitializerService @Autowired constructor(
    val databaseInitUtils: DatabaseInitUtils
){
    var datasource: DatasourceProperty? = null
    var connectionFactory: ConnectionFactory? = null

    fun saveDatasource(datasourceProperty: DatasourceProperty): Mono<*> {
        this.datasource = datasourceProperty
        return checkConnection()
    }

    fun checkConnection(): Mono<*> {
        if (datasource == null) {
            throw DatabaseNotInitException()
        }
        var c = ConnectionFactories.get(
            builder()
                .option(DRIVER, datasource!!.driver)
                .option(HOST, datasource!!.host)
                .option(PORT, datasource!!.port)
                .option(USER, datasource!!.user)
                .option(PASSWORD, datasource!!.password)
                .option(DATABASE, datasource!!.database)
                .build()
        )
        val client = DatabaseClient.create(c)
        return client.sql("SELECT VERSION()").mapValue(String::class.java).first().doOnSuccess {
            connectionFactory = c
        }.onErrorResume {
                t -> Mono.just("error")
        }
    }

    fun createTables(): Mono<Void> {
        if (connectionFactory == null || datasource == null) {
            throw DatabaseNotInitException()
        }
        return databaseInitUtils.createTables(connectionFactory!!, datasource!!.type)
    }
}