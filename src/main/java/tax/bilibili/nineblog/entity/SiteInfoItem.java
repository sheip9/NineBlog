package tax.bilibili.nineblog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import tax.bilibili.nineblog.Enum.Site.SiteInfoKey;

/**
 * SiteInfo
 *
 * @author sheip9
 * @since 2023/11/12 12:06
 */
@Data
@NoArgsConstructor
@TableName("base_info")
public class SiteInfoItem {
    @TableField("info_key")
    SiteInfoKey key;
    @TableField("table_value")
    String value;
}
