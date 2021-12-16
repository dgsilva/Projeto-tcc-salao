package br.com.tcc.feuc.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	

	/*
	 * Método que configura o modo de geração da documentação do Swagger
	 */
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.tcc.feuc"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	/*
	 * Método para personalizar o conteudo da documentação
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"API - Salão de beleza",
				"Sistema de API desenvolvido em SprignBoot com Hibernate e JPA",
				"Versão 1.0",
				"",
				new Contact("Projeto tcc faculdade feuc", "Andrey, Diego,Felipe Torneire e Felipe Guimarães", 
						""),
				"Licença da API",
				"",
				Collections.emptyList()
				);
	}	
	

}
