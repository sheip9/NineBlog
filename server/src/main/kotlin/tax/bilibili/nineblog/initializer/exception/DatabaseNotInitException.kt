package tax.bilibili.nineblog.initializer.exception

import tax.bilibili.nineblog.application.exception.BizException

class DatabaseNotInitException : BizException("数据库初始化尚未完成！")