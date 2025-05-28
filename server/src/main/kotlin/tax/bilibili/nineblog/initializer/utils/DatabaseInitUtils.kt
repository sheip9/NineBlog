package tax.bilibili.nineblog.initializer.utils

import org.hibernate.boot.MetadataSources
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy
import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.AvailableSettings
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.hibernate.tool.schema.TargetType
import org.hibernate.tool.schema.internal.SchemaCreatorImpl
import org.hibernate.tool.schema.internal.exec.GenerationTargetToScript
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToWriter
import org.hibernate.tool.schema.spi.ScriptTargetOutput
import org.hibernate.tool.schema.spi.TargetDescriptor
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.Sinks
import reactor.core.scheduler.Schedulers
import tax.bilibili.nineblog.application.entity.Article
import tax.bilibili.nineblog.application.entity.Comment
import tax.bilibili.nineblog.application.entity.User
import tax.bilibili.nineblog.application.property.DatabaseDriver.*
import tax.bilibili.nineblog.application.property.DatasourceProperty
import java.io.StringWriter
import java.util.*

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
    fun prepareSQL(datasource: DatasourceProperty): Flux<String> {
        fun getDialect(): String {
            return when (datasource.type) {
                ORACLE -> "org.hibernate.dialect.OracleDialect"
                MARIADB -> "org.hibernate.dialect.MariaDBDialect"
                SQLSERVER -> "org.hibernate.dialect.SQLServerDialect"
                MYSQL -> "org.hibernate.dialect.MySQLDialect"
                POSTGRES -> "org.hibernate.dialect.PostgreSQLDialect"
            }
        }
        println(getDialect())
        try {
            val serviceRegistry = StandardServiceRegistryBuilder()
                .applySettings(mapOf(
                    "hibernate.physical_naming_strategy" to "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy",
                    "hibernate.connection.provider_class" to "org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl",
                    "hibernate.temp.use_jdbc_metadata_defaults" to "false",
                    "hibernate.dialect" to getDialect(),
                    "hibernate.connection.url" to "jdbc:h2:mem:fake;DB_CLOSE_DELAY=-1"
                ))
                .apply {
                    settings[AvailableSettings.PHYSICAL_NAMING_STRATEGY] = object :
                        CamelCaseToUnderscoresNamingStrategy() {
                        override fun toPhysicalTableName(logicalName: Identifier?, context: JdbcEnvironment?): Identifier? {
                            val s = super.toPhysicalTableName(logicalName, context)
                            return Identifier(datasource.tablePrefix + s.text, s.isQuoted)
                        }
                    }
                }
                .build()

            val entities : Array<Class<*>> = arrayOf(Article::class.java,  Comment::class.java, User::class.java)

            val ms = MetadataSources(serviceRegistry)
            for (any in entities) {
                ms.addAnnotatedClass(any)
            }
//            ms.addAnnotatedClass(Article::class.java)
//            ms.addAnnotatedClass(Comment::class.java)
            val metadata = ms.buildMetadata(serviceRegistry)

//            val export = SchemaExport().apply {
//                setFormat(true) // 格式化SQL
//                setDelimiter(";") // 设置分隔符
//                setOutputFile("create.sql")
//                setHaltOnError(false)
//            }

            val writer = StringWriter()
            val sink = Sinks.many().replay().all<String>()

            Mono.fromRunnable<String> {
                val o = object : TargetDescriptor {
                    override fun getTargetTypes(): EnumSet<TargetType?> {
                        return EnumSet.of(TargetType.SCRIPT)
                    }

                    override fun getScriptTargetOutput(): ScriptTargetOutput {
                        return object : ScriptTargetOutputToWriter(writer) {
                            override fun accept(command: String?) {
                                super.accept(command)
                                command?.let {
                                    sink.tryEmitNext(command)
                                }
                            }
                        }
                    }
                }

                val target = GenerationTargetToScript(
                    o.scriptTargetOutput, ";"
                )

                SchemaCreatorImpl(serviceRegistry).doCreation(metadata, false, target)
                sink.tryEmitComplete()
            }.subscribeOn(Schedulers.boundedElastic()).subscribe()
            return sink.asFlux()
        } catch (e: Exception) {
            return Flux.error(e)
        }

    }

}
