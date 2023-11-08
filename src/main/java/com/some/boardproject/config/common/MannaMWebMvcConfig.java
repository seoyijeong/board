package com.some.boardproject.config.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Conponent 스캔을 통해 자동으로 Bean 생성됨
public class MannaMWebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthenticationInterceptor())
//                .excludePathPatterns("/")
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/user/auth/register")
//                .excludePathPatterns("/css/*", "/js/*", "/img/*", "/*.ico", "/error");
//    }

//    @Value("${resource.path}")
//    private String resourcePath;
//
//    @Value("${upload.path}")
//    private String uploadPath;

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler(uploadPath)
//                .addResourceLocations(resourcePath);
//    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
