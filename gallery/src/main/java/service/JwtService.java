package service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final static String SECRET_KEY = "c0f48d284981173cecb69eec54ec75f1c122bfc1d27b77d9cf08abe720e9e21e";

	private SecretKey generateKey() {
		byte[] decode = Base64.getDecoder().decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(decode);
	}

	private Claims getClaims(String token) {
		return Jwts.parser()
				.verifyWith(generateKey()) // your secret key
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}

	public boolean isExpired(String token) {
		return new Date().after(getClaims(token).getExpiration());
	}

	public String generateToken(UserDetails details) {
		HashMap<String, Object> map = new HashMap<>();

		return Jwts.builder().claims(map).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
				.subject(details.getUsername())
				.signWith(generateKey())
				.compact();
	}

}
