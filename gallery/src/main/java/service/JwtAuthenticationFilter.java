package service;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import enums.ErrorType;
import exception.BaseException;
import exception.ErrorMessage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final UserDetailService detailService;

	private final JwtService jwtService;

	public JwtAuthenticationFilter(UserDetailService detailService, JwtService jwtService) {
		super();
		this.detailService = detailService;
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");

		if (header == null || header.trim().length() == 0) {
			filterChain.doFilter(request, response);
			return;
		}
		if (!header.startsWith("Bearer"))
			throw new BaseException(new ErrorMessage(ErrorType.JWT_TOKEN_NOT_FOUND));

		String token = header.substring(7);

		String username = jwtService.getUserName(token);

		if (username != null && jwtService.isExpired(token)) {
			UserDetails userDetails = detailService.loadUserByUsername(username);
			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						username, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
	}

}
