package com.userlogin.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.userlogin.demo.handler.JWTFilter;

@Configuration
public class JwtConfig {

	@Autowired
	private JWTFilter jwtFilter;
	
	@Bean
	public FilterRegistrationBean<JWTFilter> filterRegistrationBean(){
	FilterRegistrationBean<JWTFilter> filterRegistrationBean = new FilterRegistrationBean<>();
	filterRegistrationBean.setFilter(jwtFilter);
	filterRegistrationBean.addUrlPatterns("/login/*");
	filterRegistrationBean.addUrlPatterns("/register");
    filterRegistrationBean.addUrlPatterns("/getAllUserInformation");
	filterRegistrationBean.addUrlPatterns("/update/{emailId}");
	filterRegistrationBean.addUrlPatterns("/getsingleuser/{emailId}");
	filterRegistrationBean.addUrlPatterns("/delete/{emailId}");
	filterRegistrationBean.addUrlPatterns("/deleteall");
	return filterRegistrationBean;
	}
}
