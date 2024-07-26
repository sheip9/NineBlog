package tax.bilibili.nineblog.application.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component(value = "dataSource")
@ConfigurationProperties(prefix = "nineblog.datasource")
class DataSource  {
    @Suppress("MemberVisibilityCanBePrivate")
    var type: DatabaseType? = null
    var host: String = "127.0.0.1"
    var port: Int = 3306
    var user: String = ""
    var password: String = ""
    var database: String = "nineblog"
//    var tablePrefix: String = "nb_"  // R2DBC还不能自动配置表前缀，待我后面实现
    val driver : String
        get() = type?.value.toString()
}
@Suppress("unused")
enum class DatabaseType(val value: String) {
    MYSQL("mysql"), PGSQL("postgresql"), MSSQL("mssql"), H2DB("h2")
}
