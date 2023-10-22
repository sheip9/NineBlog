package tax.bilibili.nineblog.entity;

import lombok.Data;
import tax.bilibili.nineblog.Enum.Http.HttpMessage;
import tax.bilibili.nineblog.Enum.Http.HttpStatus;

@Data
public class RestResponse<T> {
    int status;
    String message;
    T data;

    RestResponse(HttpStatus status, HttpMessage message, T data) {
        this.status = status.code;
        this.message = message.string;
        this.data = data;
    }

    public static <T> RestResponse<T> Ok(T data) {
        return new RestResponse<T>(HttpStatus.Ok, HttpMessage.SUCCESS, data);
    }

    public static <T> RestResponse<T> Ok() {
        return new RestResponse<T>(HttpStatus.Ok, HttpMessage.SUCCESS, null);
    }
}
