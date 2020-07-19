package indi.zhaosheng.jwt.config;

import indi.zhaosheng.jwt.interceptors.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author muluo
 * @description
 * @date 2020/7/19 23:13
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/login**").addPathPatterns("/**");
    }
}
