package tax.bilibili.nineblog.application.property

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "nineblog.database")
class DataSource  {
    var type: DatabaseType? = null
    var host: String = "127.0.0.1"
    var port: Int = 3306
    var user: String = ""
    var password: String = ""
    var database: String = "nineblog"
    val driver : String
        get() = type?.value.toString()
}
enum class DatabaseType(val value: String) {
    MYSQL("mysql"), PGSQL("postgresql"), MSSQL("mssql"), H2DB("h2")
}