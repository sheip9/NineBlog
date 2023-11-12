package tax.bilibili.nineblog.Enum.User;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UserStatus
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@AllArgsConstructor
@Getter
public enum UserStatus {
    //
    NORMAL(0),
    BANNED(1);
    @EnumValue
    private final int value;
}
