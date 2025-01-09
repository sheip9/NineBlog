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

    //    var tablePrefix: String = "nb_"  // R2DBC还不能自动配置表前缀，待我后面实现
    val driver: String
        get() = type.value.toString()
}

enum class DatabaseDriver(val value: String) {
    ORACLE("oracle"), H2("h2"), MARIADB("mariadb"), SQLSERVER("sqlserver"), MYSQL("mysql"), POSTGRES("postgresql"),
}
