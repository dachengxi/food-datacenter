package fun.pullock.fdc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"fun.pullock.fdc.dao.mapper"})
public class MyBatisConfig {
}
