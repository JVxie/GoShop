package com.jvxie.goshop.config;

import com.jvxie.goshop.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public UserLoginInterceptor userLoginInterceptor() {
        return new UserLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/user/login", "/user/register", "/user/register/*", "/goodsType", "/products", "/products/*")
                ;
    }
}
