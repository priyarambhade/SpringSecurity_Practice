package com.main.application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {
	
	public static String login_url ="/signin";

	//########## basic Security Which does not have logout URL#########
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		super.configure(http);
//		http.authorizeRequests()	//the secondly this authorization method runs to give access permission 
//	 	.antMatchers("/login").permitAll()
//		.antMatchers("/home/home").hasRole("ADMIN")
//		.anyRequest()				//this defines what kind of request ,we provide access
//		.authenticated()		// first this authenticated method runs to verify user 
//		.and()
//		.httpBasic();
//	}
	
	
//############# Existing form based login configuration ################3
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		super.configure(http);
//		http.csrf().disable().authorizeRequests()	//the secondly this authorization method runs to give access permission 
//		.antMatchers("/signin").permitAll()
//		.antMatchers("/home/home").hasRole("ADMIN")
//		.anyRequest()				//this defines what kind of request ,we provide access
//		.authenticated()		// first this authenticated method runs to verify user 
//		.and()
//		.formLogin()
//		.loginPage(login_url)	//Our custom login Page Url
//		.loginProcessingUrl("/dologin")	//Our custom  login Url
//		.defaultSuccessUrl("/")	//default success Url after login
//		.and().logout().logoutUrl("/logout1").permitAll() // our custom logout Url
//		;
//	}
	
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable().authorizeRequests()	//the secondly this authorization method runs to give access permission 
			.antMatchers("/signin").permitAll()
			.antMatchers("/home/home").hasRole("ADMIN")
			.anyRequest()				//this defines what kind of request ,we provide access
			.authenticated()		// first this authenticated method runs to verify user 
			.and()
			.formLogin()
			.loginPage(login_url)	//Our custom login Page Url
			.loginProcessingUrl("/dologin")	//Our custom  login Url
			.defaultSuccessUrl("/")	//default success Url after login
			.and().logout().logoutUrl("/logout1").permitAll(); // our custom logout Url
			
	        
	        return http.build();
	    }

/*	@Override
	protected void configure1(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("priya").password(this.getPasswordEndCoder().encode("priya")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("vandana").password(this.getPasswordEndCoder().encode("vandana")).roles("User");
	}*/
		
		 @Bean
		    public InMemoryUserDetailsManager userDetailsService() {
		        UserDetails user = User//.withDefaultPasswordEncoder()
		            .withUsername("priya")
		            .password(this.getPasswordEndCoder().encode("priya"))
		            .roles("ADMIN")
		            .build();
		        new InMemoryUserDetailsManager().createUser(user);
		        return new InMemoryUserDetailsManager(user);
		    }

	@Bean
	BCryptPasswordEncoder getPasswordEndCoder() {
		return new BCryptPasswordEncoder();
	}

}
