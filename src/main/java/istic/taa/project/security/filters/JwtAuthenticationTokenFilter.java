package istic.taa.project.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import istic.taa.project.constants.AppConfig;
import istic.taa.project.model.User;
import istic.taa.project.services.ITokenService;
import istic.taa.project.services.IUserService;
import istic.taa.project.services.impl.TokenServiceImpl;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private static final Logger LOG = Logger.getLogger(JwtAuthenticationTokenFilter.class);

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private TokenServiceImpl jwtTokenService;
	@Autowired
	private AppConfig config;
	@Autowired
	private ITokenService tokenService;
	@Autowired
	private IUserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestHeader = request.getHeader(config.getHeaderName());

		String username = null;
		String authToken = null;
		if (requestHeader != null && requestHeader.startsWith(config.getPrefix())) {
			// remove the bearer
			authToken = requestHeader.replace(config.getPrefix(), "");
			try {
				username = jwtTokenService.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				LOG.error("an error occured during getting username from token", e);
			} catch (ExpiredJwtException e) {
				LOG.debug("the token is expired and not valid anymore", e);
			}
		} else {
			LOG.debug("couldn't find bearer string, will ignore the header");
		}

		LOG.info("checking if the operation is a logout request");
		if (request.getServletPath().equals(config.getLogoutUrl())) {
			User u = userService.findByUsername(username);
			tokenService.invalidateToken(authToken, u);
		} else { // not logout
			LOG.info("checking if the token is still valid ");
			boolean notValid = ((tokenService.findTokenByValue(authToken) == null) ? false : true);
			LOG.info("checking authentication for user " + username);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

				if (!notValid && jwtTokenService.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					LOG.info("authenticated user " + username + ", setting security context");
					SecurityContextHolder.getContext().setAuthentication(authentication);
				} else {
					LOG.warn("The token was not valid (expired / or invalidated");
					SecurityContextHolder.getContext().setAuthentication(null);
				}
			}
		}

		chain.doFilter(request, response);
	}
}
