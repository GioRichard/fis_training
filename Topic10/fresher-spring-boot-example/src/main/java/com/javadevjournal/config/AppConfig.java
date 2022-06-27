package com.javadevjournal.config;

import com.javadevjournal.filters.CustomURLFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<CustomURLFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean();
        CustomURLFilter customURLFilter = new CustomURLFilter();

        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns("/greeting/*");
        registrationBean.setOrder(2);  //set precedence
        return registrationBean;
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
