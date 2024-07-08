package tax.bilibili.nineblog.application.constant

enum class BuiltinRoles(val value: Int) {
    OWNER(99),
    ADMIN(70),
    SUBSCRIBER(20),
    GUEST(0),
    BANNED(-1),
    ;
}