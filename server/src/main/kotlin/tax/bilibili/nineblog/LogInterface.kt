package tax.bilibili.nineblog

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

interface LogInterface {
    val log: Log
    get() = LogFactory.getLog(javaClass)
}