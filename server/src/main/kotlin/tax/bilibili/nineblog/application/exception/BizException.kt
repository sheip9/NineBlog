package tax.bilibili.nineblog.application.exception

abstract class BizException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
}