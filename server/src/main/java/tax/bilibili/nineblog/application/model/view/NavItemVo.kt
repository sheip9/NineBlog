package tax.bilibili.nineblog.application.model.view

data class NavItemVo(
    val id: Number,
    val text: String,
    val link: String,
    val priority: Int,
    val children: Array<NavItemVo>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NavItemVo

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}