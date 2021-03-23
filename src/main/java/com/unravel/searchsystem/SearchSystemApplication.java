package com.unravel.searchsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.unravel.searchsystem.repository")
@ComponentScan(basePackages = { "com.unravel.searchsystem"})
public class SearchSystemApplication{
	public static void main(String[] args) {
		SpringApplication.run(SearchSystemApplication.class, args);
	}

}
