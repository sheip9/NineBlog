package tax.bilibili.nineblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tax.bilibili.nineblog.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
