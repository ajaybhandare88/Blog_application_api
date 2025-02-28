package com.project.api.blog.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.api.blog.helper.CustomUserDetailsService;

import io.swagger.v3.oas.models.OpenAPI;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception
	{
			httpSecurity.csrf()
			.disable()
			.authorizeHttpRequests().requestMatchers("/api/user/**","/api/post/**","/api/category/**","/api/comment/**").hasRole("ADMIN")
			.requestMatchers("/v3/api-docs","/swagger-ui/**","/webjars/**","/swagger-resources/**","/test","/new/user/**").permitAll().anyRequest().permitAll().and().httpBasic();
		
		
		
		return httpSecurity.build();
	}

	 
	 
}
