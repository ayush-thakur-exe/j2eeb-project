package com.bienvenu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.bienvenu", "com.bienvenu.auth",
		"com.bienvenu.controller" })
public class AppConfig {

}
