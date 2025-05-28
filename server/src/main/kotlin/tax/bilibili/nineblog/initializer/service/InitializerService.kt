package tax.bilibili.nineblog.initializer.service

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.property.DatasourceProperty
import tax.bilibili.nineblog.initializer.exception.DatabaseNotInitException
import tax.bilibili.nineblog.initializer.utils.DatabaseInitUtils

@Service
class InitializerService @Autowired constructor(
    val databaseInitUtils: DatabaseInitUtils,
) {
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
        val c = ConnectionFactories.get(
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
        }.onErrorResume { t ->
            Mono.just("error")
        }
    }

    fun createTables(): Any {
        if (connectionFactory == null || datasource == null) {
            throw DatabaseNotInitException()
        }

        val client = DatabaseClient.create(connectionFactory!!)
//        return databaseInitUtils.prepareSQL(datasource!!).map {
//            sql -> client.sql(sql).mapValue(String::class.java).first().block()
//        }
        return databaseInitUtils.prepareSQL(datasource!!)
            .flatMap { it ->
                client
                    .sql(it)
                    .mapValue(String::class.java).one().map { it -> "success" }
                    .onErrorResume { it -> Mono.just(it.toString()) }
            }

    }
}