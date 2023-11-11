package tax.bilibili.nineblog.entity;

import lombok.Data;

/**
 * Article
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
public class Article {
    Long id;
    Long author;
    String content;

}
