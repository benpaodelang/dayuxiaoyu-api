package com.dayuxiaoyu.api.web.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 23/45
 * @since
 */

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.dayuxiaoyu.api.web.controller"})
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("dayuxiaoyu-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dayuxiaoyu.api.web.controller"))
                .paths(paths())
                .build();
    }

    private Predicate<String> paths() {
        return or(regex("/cms.*"));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("大鱼小鱼接口服务")
                .description("此API提供接口调用")
                .license("License Version 1.0")
                .version("2.0").build();
    }


}
