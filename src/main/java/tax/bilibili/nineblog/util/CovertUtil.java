package tax.bilibili.nineblog.util;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ConvertUtil 对象转换类
 *
 * @author sheip9
 * @since  2023/10/22 19:20
 */
@NoArgsConstructor
@Component
public class CovertUtil {
    /***
     * 对象的转换
     * @param sourceObj 原始对象实例
     * @param targetClass 目标对象的类
     * @return 目标对象实例
     */
    public <T> T convertObj(Object sourceObj, Class<T> targetClass) {
        if (sourceObj == null || targetClass == null) {
            return null;
        }
        T destObj = null;
        try {
            // 创建新的对象实例
            destObj = targetClass.getDeclaredConstructor().newInstance();
            // 把原对象数据拷贝到新的对象
            BeanUtils.copyProperties(sourceObj, destObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destObj;
    }

    /***
     * 列表内的对象的转换
     * @param origList 原始对象的列表
     * @param destClass 目标类
     * @return 目标对象的列表
     */
    public <T> List<T> convertList(List<?> origList, Class<T> destClass) {
        if (origList == null) {
            return null;
        }
        List<T> destList = new ArrayList<>(origList.size());
        try {
            for (Object origObj : origList) {
                T targetObject = convertObj(origObj, destClass);
                destList.add(targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destList;
    }
}
