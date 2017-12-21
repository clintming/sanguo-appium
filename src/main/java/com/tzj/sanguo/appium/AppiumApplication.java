package com.tzj.sanguo.appium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by clint on 2017/12/16.
 */

//@Controller
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@Configuration
public class AppiumApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppiumApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("200MB");
        return factory.createMultipartConfig();
    }
}
