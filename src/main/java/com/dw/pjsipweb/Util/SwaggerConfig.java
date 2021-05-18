package com.dw.pjsipweb.Util;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //配置类
@EnableSwagger2 //swagger注解

//需要在配置文件中指明该工程项目的端口号，在浏览器里输入http://localhost:指定端口号/swagger-ui.html
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("语音系统API文档")
                .description("本文档描述了语音系统中核心接口定义")
                .version("1.0")
                .contact(new Contact("dtl", "http://www.bupt821.com", "2321894289@qq.com"))
                .build();
    }
}
