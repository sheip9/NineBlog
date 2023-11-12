package tax.bilibili.nineblog.Enum.Site;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SiteInfo
 *
 * @author sheip9
 * @since 2023/11/12 12:03
 */
@Getter
@AllArgsConstructor
public enum SiteInfoKey {
    //
    TITLE("title"),
    SUB_TITLE("sub_title"),
    ;
    @EnumValue
    private final String value;
}
