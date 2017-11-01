package istic.taa.project.services;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import istic.taa.project.model.InvalidTokens;
import istic.taa.project.model.User;

public interface ITokenService {
	public String getUsernameFromToken(String token);

	public Date getIssuedAtDateFromToken(String token);

	public Date getExpirationDateFromToken(String token);

	public String getAudienceFromToken(String token);

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset);

	public String refreshToken(String token);

	public Boolean validateToken(String token, UserDetails userDetails);

	public void invalidateToken(String token, User u);

	public InvalidTokens findTokenByValue(String value);

	public InvalidTokens findTokenByUser(String value);
}
