package com.bankmanagementsystem.updateaccountdetails.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import com.bankmanagementsystem.updateaccountdetails.handler.UserHandler;

@Configuration
public class UserRouter {

	@Bean
	public RouterFunction<ServerResponse> accountRoute(UserHandler userHandler) {

		return RouterFunctions.route(PUT("/fun/update-account" + "/{id}").and(accept(APPLICATION_JSON)),
				userHandler::updateAccount);
	}

}
