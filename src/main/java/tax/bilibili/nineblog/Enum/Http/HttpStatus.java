package tax.bilibili.nineblog.Enum.Http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AHttpStatus
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@AllArgsConstructor
@Getter
public enum HttpStatus {
    //
    Ok(200);
    private final int code;
}
