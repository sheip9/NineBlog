package tax.bilibili.nineblog.application.entity

import tax.bilibili.nineblog.application.constant.IdType

data class User(
    val id: IdType,
    val username: String,
    val nickname: String,
    val email: String,
    val password: String,
    val salt: String,
    val lastLoginTime: String,
    val registrationTime: String,
)
