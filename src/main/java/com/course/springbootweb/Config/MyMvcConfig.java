package com.course.springbootweb.Config;

import com.course.springbootweb.component.LoginHandleIntercepter;
import com.course.springbootweb.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
       WebMvcConfigurer adapter= new WebMvcConfigurer(){
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("index");
               registry.addViewController("/index.html").setViewName("index");
               registry.addViewController("/main.html").setViewName("dashboard");
               registry.addViewController("/list.html").setViewName("list");
           }

           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginHandleIntercepter()).addPathPatterns("").
                       excludePathPatterns("/index.html","/","/user/login","/list.html");
           }
           @Override
           public void addCorsMappings(CorsRegistry corsRegistry) {
               //所有请求都允许跨域
               corsRegistry.addMapping("/**")
                       .allowedOrigins("*")
                       .allowedMethods("*")
                       .allowedHeaders("*");
           }
       };
       return  adapter;
    }

}
