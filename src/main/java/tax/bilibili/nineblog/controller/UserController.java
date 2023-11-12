package tax.bilibili.nineblog.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tax.bilibili.nineblog.Dto.UserDto;
import tax.bilibili.nineblog.Enum.User.UserType;
import tax.bilibili.nineblog.entity.RestResponse;
import tax.bilibili.nineblog.service.IUserService;
import tax.bilibili.nineblog.service.Impl.UserServiceImpl;

/**
 * UserController
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    IUserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    @ResponseBody
    public RestResponse<?> publicRegister(@Valid @RequestBody UserDto userDto) {
        userDto.setType(UserType.GUEST);
        int i = userService.addUser(userDto);
//        if (i < 1) {
//            return RestResponse
//        }
        return RestResponse.ok();
    }
}
