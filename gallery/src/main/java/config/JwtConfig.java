package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import service.UserDetailService;;
@Configuration
public class JwtConfig {

	private final UserDetailService detailService;
	
	public JwtConfig(UserDetailService detailService) {
		super();
		this.detailService = detailService;
	}




	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	

	@Bean
	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider(detailService);
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		return authenticationProvider;
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	{
		try {
			return authenticationConfiguration.getAuthenticationManager();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
