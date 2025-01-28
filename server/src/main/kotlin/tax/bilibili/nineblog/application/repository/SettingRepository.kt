package tax.bilibili.nineblog.application.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import tax.bilibili.nineblog.application.constant.IdType
import tax.bilibili.nineblog.application.entity.Setting

@Repository
interface SettingRepository : R2dbcRepository<Setting, IdType>