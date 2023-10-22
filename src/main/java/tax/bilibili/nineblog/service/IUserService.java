package tax.bilibili.nineblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;
import tax.bilibili.nineblog.Dto.UserDto;
import tax.bilibili.nineblog.entity.User;

@Component
public interface IUserService extends IService<User> {
    int addUser(UserDto userDto);
}
