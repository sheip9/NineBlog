package tax.bilibili.nineblog.initializer.model

import tax.bilibili.nineblog.application.property.DatasourceProperty
import tax.bilibili.nineblog.application.property.DatabaseDriver

/**
 * DatasourceModel
 * 数据库配置模型
 */
data class DatasourceModel (
    var type: DatabaseDriver,
    var host: String,
    var port: Int,
    var user: String,
    var password: String,
    var database: String,
) {
    fun toProperty() : DatasourceProperty {
        return DatasourceProperty().apply {
            this.type = this@DatasourceModel.type
            this.host = this@DatasourceModel.host
            this.port = this@DatasourceModel.port
            this.user = this@DatasourceModel.user
            this.password = this@DatasourceModel.password
            this.database = this@DatasourceModel.database
        }
    }
}