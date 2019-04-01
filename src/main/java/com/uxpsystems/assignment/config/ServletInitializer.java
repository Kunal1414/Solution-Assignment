package com.uxpsystems.assignment.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.uxpsystems.assignment.AssignmentTest3Application;



public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AssignmentTest3Application.class);
	}

	 @Bean
	 public ServletRegistrationBean h2servletRegistration() {
	     ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	     registration.addUrlMappings("/h2-console/*");
	     return registration;
	 }
}
