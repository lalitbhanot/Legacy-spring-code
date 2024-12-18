package com.lalit.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource ;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);
		
		//fun123 is the password
		
		
		/*
		 * UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication().withUser(userBuilder.username("john").password(
		 * "a").roles("ADMIN", "EMP"))
		 * .withUser(userBuilder.username("mary").password("a").roles("MANAGER", "EMP"))
		 * .withUser(userBuilder.username("lalit").password("a").roles("ADMIN",
		 * "MANAGER", "EMP"));
		 */
		// super.configure(auth); //removing it as it is giving Reason: No
		// AuthenticationProvider found for
		// org.springframework.security.authentication.UsernamePasswordAuthenticationToken
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
				// .anyRequest()
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
