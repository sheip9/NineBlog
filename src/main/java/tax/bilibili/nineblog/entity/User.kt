package tax.bilibili.nineblog.entity

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table

@Table("users")
data class User(
    @Id(keyType = KeyType.Auto)
    val id: Int,
    val username: String,
    val nickname: String,
    val email: String,
    val password: String,
    val salt: String,
    val lastLoginTime: String,
    val registrationTime: String,
)
