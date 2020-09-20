package com.net.soft.config;
import com.net.soft.interceptor.SoftInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
        registry.addInterceptor(new SoftInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/club/login","/club/index","/club/register","/login","/register","/static/**");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
