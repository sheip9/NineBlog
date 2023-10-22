package tax.bilibili.nineblog.entity;

import lombok.Data;

@Data
public class Comment {
    Long id;
    Long replyTo;
    String author;
    String email;
    String ip;
    String content;
}
