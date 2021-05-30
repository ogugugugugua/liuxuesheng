package scut.yulin.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2021/5/29
 * @Author xieyulin
 * @Description TODO
 **/
@Configuration
@MapperScan({"scut.yulin.admin.mbg.mapper", "scut.yulin.portal.mbg.mapper"})
public class MyBatisConfig {

}
