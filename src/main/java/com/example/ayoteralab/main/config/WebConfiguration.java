package com.example.ayoteralab.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	    registry.addViewController("/").setViewName("home");
	    registry.addViewController("/hello").setViewName("hello");
	    registry.addViewController("/userlogin").setViewName("userlogin");
	    registry.addViewController("/signup").setViewName("signup");
	    registry.addViewController("/user/main").setViewName("usermain");
	    registry.addViewController("/admin/main").setViewName("adminmain");
	}
	
}
