package com.sadvit.spring;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

//@Configuration
//@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ResourceConfiguration extends WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        registry
                .addResourceHandler("/projects_list/**")
                .addResourceLocations("classpath:/resources/public/app/area/projects/projects_list/");
        */
        super.addResourceHandlers(registry);
    }

}
