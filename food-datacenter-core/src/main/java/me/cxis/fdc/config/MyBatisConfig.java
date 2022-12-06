package me.cxis.fdc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"me.cxis.fdc.dao.mapper"})
public class MyBatisConfig {
}
