package tax.bilibili.nineblog.application.entity

data class User(
    val id: Int,
    val username: String,
    val nickname: String,
    val email: String,
    val password: String,
    val salt: String,
    val lastLoginTime: String,
    val registrationTime: String,
)
