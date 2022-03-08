package com.helendemo.application.testconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo commonInfo() {
        return new ApiInfoBuilder()
                .title("User Api")
                .version("1.0")
                .build();
    }
//
//    @Bean
//    public Docket allApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("USER")
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(commonInfo());
//    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.helendemo.application.testconfig"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(commonInfo());
    }
//
//    private ApiInfo commonInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot Swagger Example API",
//                "Spring Boot Swagger Example API for Youtube",
//                "1.0",
//                "Terms of Service",
//                new Contact("TechPrimers", "https://www.youtube.com/TechPrimers",
//                        "techprimerschannel@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html"
//        );
//
//        return apiInfo;
//    }

}
