package tax.bilibili.nineblog.Enum.Http;

/**
 * AHttpStatus
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
public enum HttpStatus {
    Ok(200);
    public int code;

    HttpStatus(int code) {
    }
}
