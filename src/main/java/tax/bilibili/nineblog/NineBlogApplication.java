package tax.bilibili.nineblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * NineBlogApplication
 *
 * @author sheip9
 * @since  2023/10/22 19:20
 */
@SpringBootApplication
@MapperScan("tax.bilibili.nineblog.mapper")
public class NineBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NineBlogApplication.class, args);
    }

}
