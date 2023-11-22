package br.net.galdino.restfulwebservices.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		
		//All requests should be authenticated -> return http status 403 forbidden
		//http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		//Change to publish in AWS:
		http.authorizeHttpRequests(auth -> auth
											.requestMatchers("/").permitAll() //Change to publish in AWS
											.anyRequest().authenticated());
		
		//If a request is not authenticated, a web page is shown -> shows a authentication popup
		http.httpBasic(withDefaults());
		
		//CSRF -> POST, PUT -> liberate for post & put request with authentication on header
		http.csrf().disable();
		
		return http.build();		
	}

}
