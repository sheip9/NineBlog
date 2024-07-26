package tax.bilibili.nineblog.application.service.impl

import org.springframework.stereotype.Service
import tax.bilibili.nineblog.application.constant.SettingKey
import tax.bilibili.nineblog.application.entity.Setting
import tax.bilibili.nineblog.application.model.SiteInfo
import tax.bilibili.nineblog.application.repository.SettingRepository
import tax.bilibili.nineblog.application.service.AbstractService

@Service
class SettingService : AbstractService<SettingRepository, Setting, Number>() {
    fun get() = queryAll().collectList().map{
        val map = HashMap<SettingKey, String>()
        it.forEach { map.put(it.key, it.value) }
        return@map SiteInfo(
            map.get(SettingKey.SITE_NAME)!!,
            map.get(SettingKey.SITE_TITLE)!!,
            map.get(SettingKey.SITE_NAME)!!,
            map.get(SettingKey.SITE_NAME)!!,
        )
    }
    fun update(key: SettingKey, value: String) = repository.save(Setting(key, value))
}