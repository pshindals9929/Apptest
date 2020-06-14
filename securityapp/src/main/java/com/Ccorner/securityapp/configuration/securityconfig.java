package com.Ccorner.securityapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDetailsService userdetailservice;
	
	
	
	
	
	@Bean 
	public AuthenticationManager AuthenticationManagerbean() throws Exception {
		return super.authenticationManager();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.formLogin();
		
		http.csrf().disable().authorizeRequests().antMatchers("/all","home","/register").permitAll().antMatchers("/authenticate").permitAll()
		.anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.userDetailsService( userdetailservice).passwordEncoder(passwordEncoder());
		
		
	}

	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	
	
	}
	
	

}
