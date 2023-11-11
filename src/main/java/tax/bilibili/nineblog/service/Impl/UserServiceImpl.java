package tax.bilibili.nineblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tax.bilibili.nineblog.Dto.UserDto;
import tax.bilibili.nineblog.entity.User;
import tax.bilibili.nineblog.mapper.UserMapper;
import tax.bilibili.nineblog.service.IUserService;
import tax.bilibili.nineblog.util.CovertUtil;

/**
 * UserServiceImpl
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    UserMapper userMapper;
    CovertUtil convertUtil;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, CovertUtil convertUtil) {
        this.userMapper = userMapper;
        this.convertUtil = convertUtil;
    }

    @Override
    public int addUser(UserDto userDto) {
        User user = convertUtil.convertObj(userDto, User.class);
        System.out.println(user);
        user.setRegistered(System.currentTimeMillis());
        return userMapper.insert(user);
    }
}
