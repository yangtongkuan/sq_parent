package com.yang.sq.config.knife4j;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //启用swagger2
@EnableKnife4j  // 开启knife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {

    @Autowired
    private Swagger2Properties swagger2Properties;

    @Bean
    public Docket docket(Environment environment) {
        /**
         * 判断当前的环境是不是生产环境  如果是生产环境的话 才会启用swagger2
         */
        // boolean flag = environment.acceptsProfiles("dev", "test");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())    // 文档信息
//                .enable(flag) // 是否启用swagger2
                .groupName("mr.yang") // 分组名称
                .select()
                // RequestHandlerSelectors 配置接口扫描的方式
                // basePackage 根据包路径进行扫描
                // any() 扫描全部
                // none() 全部都不扫描
                // withClassAnnotation() 类上的注解
                //withMethodAnnotation 扫描方法上指定注解
                .apis(RequestHandlerSelectors.basePackage("com.yang.sq.controller"))
//                .paths(PathSelectors.ant("/test/**")) // 过滤指定路径
                .build();
    }

    // 如果需要多个分组的时候就要创建多个docket实例
//     @Bean
//     public Docket docket1(Environment environment) {
//         /**
//          * 判断当前的环境是不是生产环境  如果是生产环境的话 才会启用swagger2
//          */
//         boolean flag = environment.acceptsProfiles("dev", "test");
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .apiInfo(buildApiInfo())    // 文档信息
// //                .enable(flag) // 是否启用swagger2
//                 .groupName("yangtk2") // 分组名称
//                 .select()
//                 // RequestHandlerSelectors 配置接口扫描的方式
//                 // basePackage 根据包路径进行扫描
//                 // any() 扫描全部
//                 // none() 全部都不扫描
//                 // withClassAnnotation() 类上的注解
//                 //withMethodAnnotation 扫描方法上指定注解
// //                .apis(RequestHandlerSelectors.basePackage("com.stu.controller"))
// //                .paths(PathSelectors.ant("/test/**")) // 过滤指定路径
//                 .build();
//     }


    private ApiInfo buildApiInfo() {
        Contact contact = new Contact(swagger2Properties.getAuthor(), swagger2Properties.getUrl(), swagger2Properties.getEmail());
        return new ApiInfo(swagger2Properties.getTitle(), swagger2Properties.getDesc(), swagger2Properties.getVersion(), "", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
