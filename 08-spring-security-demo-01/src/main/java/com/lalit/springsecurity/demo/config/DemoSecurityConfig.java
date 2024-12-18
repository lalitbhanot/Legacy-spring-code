package com.lalit.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder userBuilder = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(userBuilder.username("john").password("a").roles("EMP"))
				.withUser(userBuilder.username("mary").password("a").roles("MANAGER"))
				.withUser(userBuilder.username("lalit").password("a").roles("ADMIN"));
		// super.configure(auth); //removing it as it is giving Reason: No
		// AuthenticationProvider found for
		// org.springframework.security.authentication.UsernamePasswordAuthenticationToken
	}

}
