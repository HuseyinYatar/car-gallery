package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.AuthRequest;
import dto.AuthResponse;
import dto.DtoCustomUser;
import entity.CustomUser;
import entity.RefreshTokenRequest;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.AuthenticationSerivice;

@RestController
@RequestMapping("/rest")
public class AuthenticationController {

	AuthenticationSerivice authenticationservice;



	public AuthenticationController(AuthenticationSerivice authenticationservice) {
		super();
		this.authenticationservice = authenticationservice;
	}



	@PostMapping("/register")
	public RestBaseControllerEntity<DtoCustomUser> saveCustomUser(@RequestBody CustomUser customUser) {
		return authenticationservice.saveCustomUser(customUser);
	}
	
	@PostMapping("/login")
	public RestBaseControllerEntity<AuthResponse> authenticateUser(@Valid @RequestBody AuthRequest authRequest)
	{
		return authenticationservice.authenticateUser(authRequest);
	}
	
	@PostMapping("refresh_token")
	public RestBaseControllerEntity<AuthResponse> validateRefreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest)
	{
		return authenticationservice.validateRefreshToken(refreshTokenRequest);
		
	}

}
