package com.openwebinars.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class MiConfiguracion {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	//se agrega este comentario para ver el cambio en git
	
	/**
	 * Configuración más básica. Por defecto se permite
	 * - Todos los orígnenes
	 * - Métodos GET, HEAD, POST
	 * 
	 */
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//			}
//			
//		};
//	}
	
	/**
	 * Configuración más ajustada.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/producto/**")
					.allowedOrigins("http://localhost:9001")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.maxAge(3600);
			}
			
		};
	}
	
	
}
