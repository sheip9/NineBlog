package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.constant.SettingKey
import tax.bilibili.nineblog.application.service.impl.SettingService

@RestController
@CommonApi
@RequestMapping("/info")
class CommonInfoController @Autowired  constructor (
    val settingService: SettingService
){
    @GetMapping
    fun getInfo() = settingService.get()

    @GetMapping("/add")
    fun update() = settingService.update(SettingKey.SITE_NAME, "123")
}