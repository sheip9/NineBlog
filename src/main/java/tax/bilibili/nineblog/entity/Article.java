package tax.bilibili.nineblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Article
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
@NoArgsConstructor
@TableName("articles")
public class Article {
    @TableId(value = "id", type = IdType.AUTO)
    Long id;
    Long author;
    String content;
    Long createDate;
    Long lastEdit;
}
