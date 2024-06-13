package tax.bilibili.nineblog.service.impl

import com.mybatisflex.spring.service.impl.ServiceImpl
import tax.bilibili.nineblog.entity.Setting
import tax.bilibili.nineblog.mapper.SettingMapper
import tax.bilibili.nineblog.service.ISettingService

class SettingServiceImpl: ServiceImpl<SettingMapper, Setting>(), ISettingService {

}