package com.uxpsystems.assignment.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableCaching
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    	http
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
        http.csrf().disable();
    }
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	            .password("{noop}user")
	            .roles("USER")
	            .and()
	          .withUser("admin")
	            .password("{noop}admin")
	            .roles("USER", "ADMIN");
	    }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}



}
