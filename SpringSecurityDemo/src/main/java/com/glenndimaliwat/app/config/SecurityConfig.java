package com.glenndimaliwat.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		// Authenticate users in-memory here instead of application.properties
		/*auth.inMemoryAuthentication()
				.withUser("glenn")
				.password("password")
				.roles("ADMIN")
			.and()
				.withUser("joe")
				.password("password")
				.roles("USER");*/
		
		// Authenticate users by JPA using UserDetailService
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Secure requests with roles based on path --- This is an application wide security policy
		http.authorizeRequests()
				.antMatchers("/posts/list").permitAll() //Allow anyone to access /post/list
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")	//Use email as username (Uncomment when using JPA)
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
			.rememberMe()	// Use the default remember me scheme - TokenBasedRememberMeServices  // Do not use if more security is needed. Alternatively, use the persistent token approach
				.tokenValiditySeconds(1209600);
	}
}
