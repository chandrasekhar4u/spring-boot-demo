package com.example.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

@SpringBootApplication(scanBasePackages = { "com.example" })
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	// Delegate resource requests to default servlet
//    @Bean
//    protected DefaultServletHttpRequestHandler defaultServletHttpRequestHandler() {
//        DefaultServletHttpRequestHandler dsrh = new DefaultServletHttpRequestHandler();
//        return dsrh;
//    }
//
//	@Bean
//	public SimpleUrlHandlerMapping resourceServletMapping() {
//		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//
//		// make sure static resources are mapped first since we are using
//		// a slightly different approach
//		mapping.setOrder(0);
//		Properties urlProperties = new Properties();
//		urlProperties.put("/**/*.css", "defaultServletHttpRequestHandler");
//		urlProperties.put("/**/*.js", "defaultServletHttpRequestHandler");
//		urlProperties.put("/**/*.png", "defaultServletHttpRequestHandler");
//		urlProperties.put("/**/*.html", "defaultServletHttpRequestHandler");
//		urlProperties.put("/**/*.woff", "defaultServletHttpRequestHandler");
//		urlProperties.put("/**/*.ico", "defaultServletHttpRequestHandler");
//		mapping.setMappings(urlProperties);
//		return mapping;
//	}
}
