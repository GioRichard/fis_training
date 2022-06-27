package com.javadevjournal.springbooth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootH2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootH2Application.class, args);

        displayAllBeans(context);
    }

    public static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        int number = 1;
        for (String beanName : allBeanNames) {
            System.out.println(number + " - " + beanName);
            number++;
        }
    }
}