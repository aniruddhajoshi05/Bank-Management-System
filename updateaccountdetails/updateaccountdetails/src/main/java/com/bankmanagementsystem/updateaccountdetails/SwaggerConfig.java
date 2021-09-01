package com.bankmanagementsystem.updateaccountdetails;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bankmanagementsystem.updateaccountdetails")).build()
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Spring Reactive Case Study - Update Account Service",
				"Service used to update the account details of the users", "REST API", "Terms of service",
				new Contact("Aniruddh", "", "aniruddh@gmail.com"), "License of API", "", Collections.emptyList());
	}
	
}
