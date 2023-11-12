package tax.bilibili.nineblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

/**
 * PaginationData
 *
 * @author sheip9
 * @since 2023/11/11 22:12
 */
@Data
@AllArgsConstructor
public class PaginationData <T>{
    Collection<T> items;
    Integer total;
}
