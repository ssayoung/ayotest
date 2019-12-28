package com.example.ayoteralab.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.ayoteralab.main.auth.MyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/css/**, /static/js/**, *.ico");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.antMatchers("/", "/home", "/signup", "/usersignup").permitAll()
			.antMatchers("/", "/home", "/signup").permitAll()
			.antMatchers("/user", "/user/**").hasRole("USER")
			.antMatchers("/admin", "/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated();
		http.formLogin()
			.loginPage("/userlogin")
//			.usernameParameter("id")
//			.passwordParameter("pass")
			.defaultSuccessUrl("/#/todo")
			.permitAll();
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
			.invalidateHttpSession(true)
			.permitAll();
		http.exceptionHandling().accessDeniedPage("/user/deny");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthenticationProvider);
	}
	
}
