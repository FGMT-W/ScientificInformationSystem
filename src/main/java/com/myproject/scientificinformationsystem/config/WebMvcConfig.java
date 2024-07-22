package com.myproject.scientificinformationsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展SpringMVC功能
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //视图映射
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/thesis/**").addResourceLocations("file:src/main/resources/static/");
        registry.addResourceHandler("/papers/**").addResourceLocations("file:src/main/resources/static/");
        registry.addResourceHandler("/results/**").addResourceLocations("file:src/main/resources/static/");
    }

}
