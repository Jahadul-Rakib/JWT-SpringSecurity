package com.rakib.config;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTUserNameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public JWTUserNameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	//Processing User Log in Request Using UserName and Password
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			AuthenticationRequestDTO authenticationRequestDTO = new ObjectMapper()
					.readValue(request.getInputStream(), AuthenticationRequestDTO.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(),
					authenticationRequestDTO.getPassword());

			Authentication authenticate = authenticationManager.authenticate(authentication);
			return authenticate;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	//Processing for send generated Auth Token
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
    String Key = "SECUREOFFNOSECURITY@333";
		
	String token = Jwts.builder()
		                        .setSubject(authResult.getName())
		                        .claim("authorities", authResult.getAuthorities())
		                        .setIssuedAt(new java.util.Date())
		                        .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
		                        .signWith(Keys.hmacShaKeyFor(Key.getBytes()))
		                        .compact();
		
	
	response.addHeader("Authorization", "Bearer "+token);
	}
}
