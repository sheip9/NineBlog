package tax.bilibili.nineblog.application.entity

import org.springframework.data.annotation.Id

data class NavItem(
    @Id
    val id: Number,
    val text: String,
    val link: String,
    val priority: Int,
    val parentItem: Number?
)