package tax.bilibili.nineblog.Enum.Http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HttpMessage
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@AllArgsConstructor
@Getter
public enum HttpMessage {
    //
    SUCCESS("Success!");
    private final String value;

}
