package tax.bilibili.nineblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tax.bilibili.nineblog.entity.Article;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
