package tax.bilibili.nineblog.entity;

import lombok.Data;

/**
 * Comment
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
public class Comment {
    Long id;
    Long replyTo;
    String author;
    String email;
    String ip;
    String content;
}
