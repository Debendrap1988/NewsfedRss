package com.newsfed.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.newsfed.serviceImpl.NewsfedUserDetailService;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private NewsfedUserDetailService userDetailsService;
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.antMatchers(HttpMethod.POST, "/manager").hasAuthority("MANAGER")
			.antMatchers(HttpMethod.PUT, "/manager").hasAuthority("MANAGER")
			.antMatchers(HttpMethod.DELETE, "/manager").hasAuthority("MANAGER")
			.antMatchers("/manager/**").hasAuthority("MANAGER")
			.antMatchers("/user/**").hasAuthority("USER")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("pass")
		.roles("USER")
		.and()
		.withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/**")
		.hasRole("ADMIN")
		.antMatchers("/**")
		.permitAll().and().formLogin();
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.antMatcher("/**")  
         .authorizeRequests()  
         .antMatchers("/").permitAll()  
         .anyRequest().authenticated()
         .and().formLogin();  
	}*/
}
