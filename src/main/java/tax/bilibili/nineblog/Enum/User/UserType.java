package tax.bilibili.nineblog.Enum.User;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {
    OWNER(0), ADMIN(1), NORMAL(2), GUEST(3);
    @EnumValue
    private final int value;
}
