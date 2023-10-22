package tax.bilibili.nineblog.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import tax.bilibili.nineblog.Enum.User.UserType;

/**
 * @author sheip9
 */
@Data
@AllArgsConstructor
public class UserDto {
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String username;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9./!@#$%^&*]+$")
    private String pass;
    private UserType type;

    public UserType getType() {
        return type == null ? UserType.NORMAL : type;
    }
}
