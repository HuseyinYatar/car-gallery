package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import handler.AuthEntryPoint;
import service.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final JwtAuthenticationFilter authenticationFilter;

	private final AuthenticationProvider authenticationProvider;
	
	private final AuthEntryPoint authEntryPoint;

	private static final String REGISTER = "/rest/register/**";

	private static final String LOGIN = "/rest/login/**";

	private static final String REFRESH_TOKEN = "/rest/refresh_token";

	public SecurityConfig(JwtAuthenticationFilter authenticationFilter, AuthenticationProvider authenticationProvider, AuthEntryPoint authEntryPoint) {
		super();
		this.authenticationFilter = authenticationFilter;
		this.authenticationProvider = authenticationProvider;
		this.authEntryPoint = authEntryPoint;
	}

	@Bean
	SecurityFilterChain chain(HttpSecurity httpSecurity) {
		try {
			return httpSecurity.csrf(t -> t.disable())
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authorizeHttpRequests(t -> t.requestMatchers(REGISTER, LOGIN, REFRESH_TOKEN).permitAll())
					.authorizeHttpRequests(t -> t.anyRequest().authenticated())
					.exceptionHandling(t->t.authenticationEntryPoint(authEntryPoint))
					.httpBasic(Customizer.withDefaults())
					.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
					.authenticationProvider(authenticationProvider)
					.build();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
