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
public class AuthenticationController extends RestBaseController {

	AuthenticationSerivice authenticationservice;



	public AuthenticationController(AuthenticationSerivice authenticationservice) {
		super();
		this.authenticationservice = authenticationservice;
	}



	@PostMapping("/register")
	public RestBaseControllerEntity<RestBaseControllerEntity<DtoCustomUser>> saveCustomUser(@RequestBody CustomUser customUser) {
		return ok(authenticationservice.saveCustomUser(customUser));
	}
	
	@PostMapping("/login")
	public RestBaseControllerEntity<RestBaseControllerEntity<AuthResponse>> authenticateUser(@Valid @RequestBody AuthRequest authRequest)
	{
		return ok(authenticationservice.authenticateUser(authRequest));
	}
	
	@PostMapping("refresh_token")
	public RestBaseControllerEntity<RestBaseControllerEntity<AuthResponse>> validateRefreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest)
	{
		return ok(authenticationservice.validateRefreshToken(refreshTokenRequest));
		
	}

}
