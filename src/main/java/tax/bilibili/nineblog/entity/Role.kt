package tax.bilibili.nineblog.entity

import com.mybatisflex.annotation.Table

@Table("roles")
data class Role(
    val id: Int,
    val level: Int,
    val name: String,
    val description: String,
    val isBuiltIn: Boolean,
)
