package tax.bilibili.nineblog.application.service.impl

import com.mybatisflex.spring.service.impl.ServiceImpl
import tax.bilibili.nineblog.application.entity.Setting
import tax.bilibili.nineblog.application.mapper.SettingMapper
import tax.bilibili.nineblog.application.service.ISettingService

class SettingServiceImpl: ServiceImpl<SettingMapper, Setting>(), ISettingService {

}