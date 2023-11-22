package br.net.galdino.restapi.security.config.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //filter chain
		return 
			http
			.authorizeHttpRequests( auth -> auth
											.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
											.anyRequest().authenticated() ) //authenticate all requests
			.httpBasic(Customizer.withDefaults()) //enable basic authentication->open popup for user/pass OR authentication header
			.sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) ) //conf stateless session
			.csrf().disable() // disable csrf(protection against Cross Site Request Forgery)
			.build();
	}

}
