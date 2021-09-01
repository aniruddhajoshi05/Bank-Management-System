package com.bank;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bank")).build()
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Spring Reactive Case Study - Loan Details",
				"Service used to apply loan and get loan details", "REST API", "Terms of service",
				new Contact("Sanchit", "", "sanchit@gmail.com"), "License of API", "", Collections.emptyList());
	}
}