package com.uxpsystems.assignment;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages= {"com.uxpsystems.assignment"})
public class AssignmentTest3Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentTest3Application.class, args);
	}
	
	 @Bean
	 public ServletRegistrationBean h2servletRegistration() {
	     ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	     registration.addUrlMappings("/h2-console/*");
	     return registration;
	 }

}
