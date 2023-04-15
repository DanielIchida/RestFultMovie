package com.test.movie;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public GroupedOpenApi movieOpenApi(@Value("${springdoc.version}") String appVersion) {
		String[] paths = { "/movie/**" , "/movies/**" };
		String[] packagedToMatch = { "com.test.movie.infrastructure.restful.controllers.movies" };
		return GroupedOpenApi.builder().
				group("moviedb")
				.addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Movies API").version(appVersion)))
				.pathsToMatch(paths).packagesToScan(packagedToMatch)
				.build();
	}

	@Bean
	public GroupedOpenApi favoriteListOpenApi(@Value("${springdoc.version}") String appVersion) {
		String[] paths = { "/favorite/list" , "/favorite/list/**" };
		String[] packagedToMatch = { "com.test.movie.infrastructure.restful.controllers.favorites" };
		return GroupedOpenApi.builder().group("favorite")
				.addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Favorite List API").version(appVersion)))
				.pathsToMatch(paths).packagesToScan(packagedToMatch)
				.build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("MovieDB API")
						.description("MovieDB API sample application")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("MovieDB API Documentation")
						.url("https://www.themoviedb.org/documentation/api"));
	}

}
