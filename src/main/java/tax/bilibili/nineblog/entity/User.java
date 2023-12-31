package tax.bilibili.nineblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import tax.bilibili.nineblog.Enum.User.UserType;

/**
 * Article
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
@TableName("users")
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    Long id;
    String username;
    String pass;
    String nickname;
    String email;
    Long registered;
    UserType type;
}
