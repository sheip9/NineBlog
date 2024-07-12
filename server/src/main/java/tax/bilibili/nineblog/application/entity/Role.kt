package tax.bilibili.nineblog.application.entity

data class Role(
    val id: Int,
    val level: Int,
    val name: String,
    val description: String,
    val isBuiltIn: Boolean,
)
