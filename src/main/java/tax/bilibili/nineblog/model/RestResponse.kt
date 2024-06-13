package tax.bilibili.nineblog.model

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class RestResponse<T>(
    val status: Int,
    val message: Serializable,
    val data: T?,
) : Serializable {
    constructor(status: Int,message: Serializable) : this(status, message, null)
    constructor(status: HttpStatus,message: Serializable) : this(status.value(), message, null)
    constructor(status: HttpStatus,message: Serializable, data: T?) : this(status.value(), message, data)
}
