package com.geppetto.surveybuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class GPSurveyBuilder extends SpringBootServletInitializer {

	///THIS IS FOR CROSS ORGIN SUPPORT
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                
                  registry.addMapping("/**").allowCredentials(false).
                  allowedOrigins("*").allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE");
                                  
            }
        };
    }
	
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GPSurveyBuilder.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GPSurveyBuilder.class, args);
	}
}
