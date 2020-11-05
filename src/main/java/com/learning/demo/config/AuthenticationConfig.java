package com.learning.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@EnableWebMvc
@Configuration
public class AuthenticationConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }

    @Bean
    public OptionsInterceptor optionsInterceptor(){
        return new OptionsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(optionsInterceptor())
                .addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/admin/**")
                .addPathPatterns("/department/**")
                .addPathPatterns("/student/**")
                .addPathPatterns("/excel/download")
                .excludePathPatterns("/student/addStudent")
                .excludePathPatterns("/department/getDepartmentByName","/department/getDepartments")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
