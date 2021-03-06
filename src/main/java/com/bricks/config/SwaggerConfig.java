package com.bricks.config;

import com.bricks.controller.GoalTrackerController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = GoalTrackerController.class)
@Configuration
public class SwaggerConfig {
    private static final String SWAGGER_API_VERSION = "1.0.0";
    private static final String LICENSE_TEXT = "License";
    private static final String title = "Bricks: Goal Tracker REST API";
    private static final String description = "RESTful API for the Bricks Application";

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket bricksApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bricks.controller"))
                .build();
    }
}
