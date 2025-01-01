package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.SettingKey
import tax.bilibili.nineblog.application.entity.Setting

@Repository
interface SettingRepository : R2dbcRepository<Setting, Number> {
    @Modifying
    @Query(
        "UPDATE Setting " +
                "SET value = :value " +
                "WHERE key = :key"
    )
    fun updateByKey(key: SettingKey, value: String): Mono<Boolean>
}