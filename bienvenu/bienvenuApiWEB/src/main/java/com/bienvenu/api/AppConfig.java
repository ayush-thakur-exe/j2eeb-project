package com.bienvenu.api;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Configuration
@Import({
    com.bienvenu.config.BienvenuConfig.class,
    com.bienvenu.api.SecurityConfig.class 
})
@EnableJpaRepositories(basePackages = "com.bienvenu.repository")
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.bienvenu.api.service",
    "com.bienvenu.service",
    "com.bienvenu.api.controller",
    "com.bienvenu.auth",
    "com.bienvenu.config",
    "com.bienvenu.repository" // still needed if repositories used
})
public class AppConfig implements WebMvcConfigurer {
	
	@Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // fix for LocalDate
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // ISO-8601

        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }
}
