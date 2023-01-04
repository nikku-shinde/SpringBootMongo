package com.example.spring_with_mongo_db.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwtToken = extractJwtFromRequest(request);
//			StringUtils.hasLength(jwtToken)
			if (jwtToken != null && jwtUtil.validateToken(jwtToken)) {
				UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(jwtToken), "",
						jwtUtil.getRolesFromToken(jwtToken));
				System.out.println(userDetails);

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, "", jwtUtil.getRolesFromToken(jwtToken));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("cannot set the security context");
			}

		} catch (ExpiredJwtException e) {

			request.setAttribute("exception", e);

		} catch (BadCredentialsException e) {

			request.setAttribute("exception", e);

		}
		System.out.println("after fileter");
		System.out.println(filterChain);
		try {
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");

		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}

		return null;
	}

}
