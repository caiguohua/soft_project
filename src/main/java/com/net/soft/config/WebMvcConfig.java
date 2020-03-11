package com.net.soft.config;
import com.net.soft.interceptor.InterceptorConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author caiguohua
 * @date 2020/3/8 18:36
 * @Email:cai.beyond@qq.com
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/softImage/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/club/login","/club/index","/club/register","/login","/register");
    }
}
