package com.sadvit.spring;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ResourceConfiguration extends WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/resources/public/**").addResourceLocations("classpath:/resources/**");
        super.addResourceHandlers(registry);
    }

}
