package tax.bilibili.nineblog.entity

import com.mybatisflex.annotation.Table

@Table("setting")
data class Setting(val key: String, val value: String)
