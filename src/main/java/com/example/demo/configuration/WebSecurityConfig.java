package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailService userDetailsService;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/").hasAnyRole("ADMIN","EDITOR","USER")
			.antMatchers("/users_log").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/list_user").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/user_register").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/users").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/categories").hasAnyRole("ADMIN","EDITOR")
			.antMatchers("/request").hasAnyRole("ADMIN","EDITOR","USER")
			.antMatchers("/request_form").hasAnyRole("ADMIN","EDITOR","USER")
			.antMatchers("/request_temp").hasAnyRole("ADMIN","EDITOR","USER")
			.antMatchers("/").hasAnyRole("ADMIN","EDITOR","USER")
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/login");
			
		
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
