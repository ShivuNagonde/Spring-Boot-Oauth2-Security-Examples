package com.hello;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableResourceServer
@SpringBootApplication
public class HelloAppln {

	public static void main(String[] args) {
		SpringApplication.run(HelloAppln.class,args);
	}
	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}
	@Configuration
	protected static class AuthenticationManagerConfiguration extends 
	GlobalAuthenticationConfigurerAdapter {

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("javainuse-user")
			.password("javainuse-pass").roles("USER");
		}
  }
}