package com.java.spring_restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


//配置了swagger的Docket的bean实例
    //enable是否启动swagger，如果为false，则swagger不能在浏览器中使用
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //获取项目的环境：
        //通过环境监听命令 environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag  = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("hello")
                .enable(true)
                .select()
                //requestHandlerSelectors 配置要扫描接口的方式
                //basepackage:指定要扫描的包
                //any();扫描全部
                //none（）;不扫描
                //withClassAnnotation:扫描类上的注解,参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.java.spring_restful"))
                //paths()过滤什么路径
                //.paths(PathSelectors.ant("/"))
                .build();
    }

    //配置swagger信息 = Apiinfo
    private ApiInfo apiInfo(){

        Contact contact = new Contact("秦将","","lpf18366313221@outlook.com");
        return new ApiInfo(
                "swagger API文档",
                "再小的帆也能远航",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSES-2.0",
                new ArrayList());
    }
}



