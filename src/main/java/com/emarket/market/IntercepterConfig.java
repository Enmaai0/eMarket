package com.emarket.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Autowired
    private UserLoginInterceptor userLoginIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginIntercepter)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login",
                        "/user/register"
                );
    }
}
