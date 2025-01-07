package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.IdType
import tax.bilibili.nineblog.application.constant.SettingKey
import tax.bilibili.nineblog.application.entity.Setting

@Repository
interface SettingRepository : R2dbcRepository<Setting, IdType> {
    @Modifying
    @Query(
        "INSERT INTO setting (`name`, `value`)" +
                "VALUES" +
                "(:name, :value)" +
                "ON DUPLICATE KEY UPDATE `value` = :value;"
    )
    fun updateByKey(name: SettingKey, value: String): Mono<Boolean>
}