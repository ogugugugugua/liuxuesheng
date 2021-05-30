package scut.yulin.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"scut.yulin.admin.mbg.mapper", "scut.yulin.mbg.mbg.mapper"})
public class MybatisConfig {
}
