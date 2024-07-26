package tax.bilibili.nineblog.application.service.impl

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tax.bilibili.nineblog.application.constant.SettingKey
import tax.bilibili.nineblog.application.entity.Setting
import tax.bilibili.nineblog.application.model.SiteInfo
import tax.bilibili.nineblog.application.repository.SettingRepository
import tax.bilibili.nineblog.application.service.AbstractService

@Service
class SettingService : AbstractService<SettingRepository, Setting, Number>() {
    fun getSiteInfo(): Mono<SiteInfo> = queryAll().collectList().flatMap{ it ->
        val map = HashMap<SettingKey, String>()
        it.forEach { map[it.key] = it.value }
        return@flatMap Mono.just(SiteInfo(
            map[SettingKey.SITE_NAME]!!,
            map[SettingKey.SITE_TITLE]!!,
            map[SettingKey.SITE_SUBTITLE]!!,
            map[SettingKey.SITE_FOOTER]!!,
        ))
    }

    fun updateOneSetting(key: SettingKey, value: String): Mono<Boolean> = repository.updateByKey(key, value)
}