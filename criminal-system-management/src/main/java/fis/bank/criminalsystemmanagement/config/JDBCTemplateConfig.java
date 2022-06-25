package fis.bank.criminalsystemmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class JDBCTemplateConfig {
    @Configuration
    @ComponentScan(basePackages = {"fis.bank"})
    public class JdbcTemplateConfig {
    }
}
