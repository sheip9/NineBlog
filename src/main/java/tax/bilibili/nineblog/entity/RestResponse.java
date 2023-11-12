package tax.bilibili.nineblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tax.bilibili.nineblog.Enum.Http.HttpMessage;
import tax.bilibili.nineblog.Enum.Http.HttpStatus;

/**
 * RestResponse
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {
    private int status;
    private String message;
    private T data;

    public RestResponse(HttpStatus status, HttpMessage message, T data) {
        this.status = status.getCode();
        this.message = message.getValue();
        this.data = data;
    }

    public static <T> RestResponse<T> ok(T data) {
        return new RestResponse<>(HttpStatus.Ok, HttpMessage.SUCCESS, data);
    }

    public static <T> RestResponse<T> ok() {
        return new RestResponse<>(HttpStatus.Ok, HttpMessage.SUCCESS, null);
    }
}
