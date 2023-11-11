package tax.bilibili.nineblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tax.bilibili.nineblog.entity.Article;

/**
 * ArticleMapper
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
