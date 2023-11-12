package tax.bilibili.nineblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Comment
 *
 * @author sheip9
 * @since 2023/10/22 19:31
 */
@Data
@NoArgsConstructor
@TableName("comments")
public class Comment {
    @TableId(value = "id", type = IdType.AUTO)
    Long id;
    Long replyTo;
    String author;
    String email;
    String ip;
    String content;
}
