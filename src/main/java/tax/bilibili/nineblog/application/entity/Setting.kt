package tax.bilibili.nineblog.application.entity

import com.mybatisflex.annotation.Table

@Table("setting")
data class Setting(val key: String, val value: String)
