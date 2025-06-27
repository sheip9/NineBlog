package tax.bilibili.nineblog.application.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.DefaultNamingStrategy
import org.springframework.data.relational.core.mapping.NamingStrategy
import tax.bilibili.nineblog.application.property.DatasourceProperty

@Configuration
open class CustomNamingStrategy @Autowired constructor(val datasource: DatasourceProperty) {
    @Bean
    open fun namingStrategy(): NamingStrategy {
        return object : DefaultNamingStrategy() {
            override fun getTableName(type: Class<*>): String {
                return datasource.tablePrefix + super.getTableName(type)
            }
        }
    }
}