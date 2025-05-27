package tax.bilibili.nineblog.application.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "nineblog.datasource")
class DatasourceProperty {
    var type: DatabaseDriver = DatabaseDriver.MYSQL
    var host: String = "127.0.0.1"
    var port: Int = 3306
    var user: String = ""
    var password: String = ""
    var database: String = "nineblog"
    var tablePrefix: String = "nb_"
    val driver: String
        get() = type.value
}

enum class DatabaseDriver(val value: String) {
    ORACLE("oracle"), MARIADB("mariadb"), SQLSERVER("sqlserver"), MYSQL("mysql"), POSTGRES("postgresql"),
}
