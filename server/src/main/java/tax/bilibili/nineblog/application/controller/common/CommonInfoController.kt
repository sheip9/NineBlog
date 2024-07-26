package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.service.impl.SettingService

@RestController
@CommonApi
@RequestMapping("/info")
class CommonInfoController @Autowired  constructor (
    private val settingService: SettingService
){
    @GetMapping
    fun getInfo() = settingService.getSiteInfo()

}