package com.dw.pjsipweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.dw.pjsipweb.mapper")
@SpringBootApplication
@ComponentScan(basePackages = {"com.dw"})
public class PjsipwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjsipwebApplication.class, args);
    }

}
