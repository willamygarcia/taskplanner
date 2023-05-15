package br.com.cobax.taskpanner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class WebSecurityConfig{
	
	private final String[] GET_WHITELIST = {
			"/tarefa"};
	
	private final String[] POST_WHITELIST = {
			"/tarefa"};
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService user() {
		UserDetails userDetails = User.builder()
				.username("willamy")
				.password(passwordEncoder().encode("Wget"))
				.roles("USER")
				.build();
		System.out.println(passwordEncoder().encode("Wget"));
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(withDefaults()).cors(withDefaults())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authorize) -> authorize
                		.requestMatchers(HttpMethod.GET, GET_WHITELIST).hasRole("USER")
                        .requestMatchers(HttpMethod.POST, POST_WHITELIST).hasRole("ADMIN")
                        .anyRequest().authenticated());

        return http.build();
	}
	

		
		
		
	

}
