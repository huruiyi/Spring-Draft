package com.vk.liyj.config;


import com.vk.liyj.interceptor.LiyjInterceptor;
import com.vk.liyj.interceptor.ShanInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringInterceptorRegister extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory
            .getLogger(SpringInterceptorRegister.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LiyjInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new ShanInterceptor()).addPathPatterns("/freemarker/**");
        super.addInterceptors(registry);
    }

    /*
     * 注册静态文件的自定义映射路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
        registry.addResourceHandler("/picture/**").addResourceLocations("file:D:/picture/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
