package tax.bilibili.nineblog.initializer.utils

import io.r2dbc.spi.ConnectionFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.property.DatabaseDriver
import tax.bilibili.nineblog.application.property.DatabaseDriver.*

/**
 * DatabaseInitUtils
 * 数据库初始化类
 */
@Component
class DatabaseInitUtils {
    /**
     * createTables
     * 创建表
     */
    fun createTables(cf: ConnectionFactory, driveType: DatabaseDriver): Mono<Void> {
        var cdp = CompositeDatabasePopulator()
        cdp.addPopulators(getSQLResource("initializer/table_creating.sql"))
        //针对不同品牌数据库创建自增主键 索引等
        when (driveType) {
            MYSQL -> cdp.addPopulators(getSQLResource("initializer/mysql.sql"))
            POSTGRES -> cdp.addPopulators(getSQLResource("initializer/postgres.sql"))
            SQLSERVER -> null
            H2 -> null
            else -> null
        }

        return cdp.populate(cf)
    }

    private fun getSQLResource(filename: String): ResourceDatabasePopulator {
        return ResourceDatabasePopulator(ClassPathResource(filename))
    }
}
