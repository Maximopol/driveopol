package com.maximopol.driveopol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("public/login");
        registry.addViewController("/admin/dbtool").setViewName("admin/dbtool");
    }
}
