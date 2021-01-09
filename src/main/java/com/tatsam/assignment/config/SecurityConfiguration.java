package com.tatsam.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Sohan Yadav
 * @implSpec:  This is security configuration class which handle role based authentication with having
 * userDetailsService : user bean 
 * configure() : for role based restriction
 * configureGlobal() : injecting userDetails in AuthenticationManagerBuilder
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/api/priority/getPriority", "/api/priority/addPriority").hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	/*
	 * @Override
	 * 
	 * @Bean protected UserDetailsService userDetailsService() {
	 * 
	 * UserDetails admin = User.builder() .username("admin")
	 * .password(passwordEncoder.encode("admin")) .roles("ADMIN") .build();
	 * 
	 * UserDetails user1 = User.builder() .username("user1")
	 * .password(passwordEncoder.encode("user1")) .roles("USER") .build();
	 * 
	 * UserDetails user2 = User.builder() .username("user2")
	 * .password(passwordEncoder.encode("user2")) .roles("USER") .build();
	 * 
	 * UserDetails user3 = User.builder() .username("user3")
	 * .password(passwordEncoder.encode("user3")) .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(admin, user1, user2, user3); }
	 */
}
