package service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dto.AuthRequest;
import dto.AuthResponse;
import dto.DtoCustomUser;
import entity.CustomUser;
import entity.RefreshToken;
import entity.RefreshTokenRequest;
import entity.RestBaseControllerEntity;
import enums.ErrorType;
import exception.BaseException;
import jakarta.validation.Valid;
import mapper.CustomUserMapping;
import repository.CustomUserRepository;
import repository.RefreshTokenRepository;

@Service
public class AuthenticationSerivice {

	private final JwtService jwtService;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final CustomUserRepository customUserRepository;

	private final CustomUserMapping customUserMapping;

	private final AuthenticationProvider authenticationProvider;

	private final RefreshTokenRepository refreshTokenRepository;

	public AuthenticationSerivice(CustomUserRepository customUserRepository, CustomUserMapping customUserMapping,
			BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationProvider authenticationProvider,
			JwtService jwtService, RefreshTokenRepository refreshTokenrepository) {
		super();
		this.customUserRepository = customUserRepository;
		this.customUserMapping = customUserMapping;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.authenticationProvider = authenticationProvider;
		this.jwtService = jwtService;
		this.refreshTokenRepository = refreshTokenrepository;
	}

	private boolean refreshTokenExpired(RefreshToken refreshToken) {
		return new Date().after(refreshToken.getExpiredDate());
	}

	public RestBaseControllerEntity<DtoCustomUser> saveCustomUser(CustomUser customUser) {
		DtoCustomUser dtoCustomUser = customUserMapping.customuserToDtoCustomUser(customUser);
		customUserRepository.save(passwordEncoder(customUser));

		return RestBaseControllerEntity.ok(dtoCustomUser);
	}

	private CustomUser passwordEncoder(CustomUser customUser) {
		String encodedPass = bCryptPasswordEncoder.encode(customUser.getPassword());
		customUser.setPassword(encodedPass);

		return customUser;
	}

	private RefreshToken generateRefreshToken(CustomUser customUser) {

		return RefreshToken.builder().token(UUID.randomUUID().toString())
				.expiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)).customUser(customUser)
				.issueDate(new Date()).build();
	}

	public RestBaseControllerEntity<AuthResponse> authenticateUser(AuthRequest authRequest) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				authRequest.getUsername(), authRequest.getPassword());

		authenticationProvider.authenticate(authenticationToken);

		Optional<CustomUser> byUserName = customUserRepository.findByUserName(authRequest.getUsername());

		String accessToken = jwtService.generateToken(byUserName.get());

		RefreshToken refreshToken = generateRefreshToken(byUserName.get());

		RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);
		return RestBaseControllerEntity.ok(new AuthResponse(accessToken, savedRefreshToken.getToken()));
	}

	public RestBaseControllerEntity<AuthResponse> validateRefreshToken(@Valid RefreshTokenRequest refreshTokenRequest) {
		
		Optional<RefreshToken> byToken = refreshTokenRepository.findByToken(refreshTokenRequest.getToken());
		
		if(!byToken.isPresent())
		throw new BaseException(ErrorType.REFRESH_TOKEN_NOT_FOUND,refreshTokenRequest.getToken());
		
		RefreshToken refreshToken = byToken.get();
		
		if(refreshTokenExpired(refreshToken))
			throw new BaseException(ErrorType.REFRESH_TOKEN_EXPIRED,refreshToken.getExpiredDate().toString());

		
		CustomUser customUser = refreshToken.getCustomUser();
		
		String accessToken = jwtService.generateToken(customUser);
		
		RefreshToken newRefreshToken = generateRefreshToken(customUser);

		RefreshToken savedRefreshToken = refreshTokenRepository.save(newRefreshToken);
		
		return RestBaseControllerEntity.ok(new AuthResponse(accessToken, savedRefreshToken.getToken()));
		
	}

}
