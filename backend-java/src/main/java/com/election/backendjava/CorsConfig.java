package com.election.backendjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Specificeer de endpoints waarvoor CORS toegestaan moet zijn
                        .allowedOrigins("http://localhost:5173", "http://localhost:5174", "http://localhost:5175") // Toegestane origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Toegestane HTTP-methoden
                        .allowedHeaders("*") // Toegestane headers
                        .allowCredentials(true); // Staat cookies en autorisatie-informatie toe
            }
        };
    }
}