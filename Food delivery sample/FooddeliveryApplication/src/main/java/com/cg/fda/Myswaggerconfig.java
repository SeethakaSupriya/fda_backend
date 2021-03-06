package com.cg.fda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


 

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


 

@Configuration
@EnableSwagger2
public class Myswaggerconfig {
@Bean
public Docket postApi() {
return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(PathSelectors.regex("/api/v2.*")).build();
}

@SuppressWarnings("deprecation")
private ApiInfo metadata() {
return new ApiInfoBuilder().title("FoodCart Details").description("API reference guide for developers").termsOfServiceUrl("").contact("Batra,Yatin").version("1.0").build();
}


 

}