package com.yang.sq.config.intecepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring 拦截器配置
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getCustomTenantInterceptor()).addPathPatterns("/tenant/v1/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public CustomTenantInterceptor getCustomTenantInterceptor() {
        return new CustomTenantInterceptor();
    }
}
