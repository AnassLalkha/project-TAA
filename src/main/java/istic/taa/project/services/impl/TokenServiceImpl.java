package istic.taa.project.services.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import istic.taa.project.constants.AppConfig;
import istic.taa.project.dao.IInvalidTokensDao;
import istic.taa.project.model.InvalidTokens;
import istic.taa.project.model.User;
import istic.taa.project.security.UserAccount;
import istic.taa.project.services.ITokenService;
import istic.taa.project.utils.EncodingUtils;

@Component
public class TokenServiceImpl implements Serializable, ITokenService {

	private static final long serialVersionUID = -3301605591108950415L;
	@Autowired
	private AppConfig config;
	@Autowired
	private IInvalidTokensDao tokensDao;

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_AUDIENCE = "aud";
	static final String CLAIM_KEY_CREATED = "iat";

	static final String AUDIENCE_UNKNOWN = "unknown";
	static final String AUDIENCE_WEB = "web";
	static final String AUDIENCE_MOBILE = "mobile";
	static final String AUDIENCE_TABLET = "tablet";

	@Override
	public String getUsernameFromToken(String token) {
		String encodedUsername = getClaimFromToken(token, Claims::getSubject);
		return EncodingUtils.decodeUsername(encodedUsername);
	}

	@Override
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	@Override
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	@Override
	public String getAudienceFromToken(String token) {
		return getClaimFromToken(token, Claims::getAudience);
	}

	@Override
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(config.getSecret()).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date exp = getExpirationDateFromToken(token);
		return exp.before(new Date());
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	private String generateAudience(Device device) {
		String audience = AUDIENCE_UNKNOWN;
		if (device.isNormal()) {
			audience = AUDIENCE_WEB;
		} else if (device.isTablet()) {
			audience = AUDIENCE_TABLET;
		} else if (device.isMobile()) {
			audience = AUDIENCE_MOBILE;
		}
		return audience;
	}

	private Boolean ignoreTokenExpiration(String token) {
		String audience = getAudienceFromToken(token);
		return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
	}

	public String generateToken(UserDetails userDetails, Device device) {
		Map<String, Object> claims = new HashMap<>();
		String username = EncodingUtils.encodeUsername(userDetails.getUsername(), config.getUsernameSuffix(),
				config.getUsername());
		return doGenerateToken(claims, username, generateAudience(device));
	}

	private String doGenerateToken(Map<String, Object> claims, String subject, String audience) {
		final Date createdDate = new Date();
		final Date expirationDate = calculateExpirationDate(createdDate);

		String jwt = Jwts.builder().setClaims(claims).setSubject(subject).setAudience(audience).setIssuedAt(createdDate)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, config.getSecret()).compact();
		return new StringBuilder(config.getPrefix()).append(jwt).toString();
	}

	@Override
	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = getIssuedAtDateFromToken(token);
		return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
				&& (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	@Override
	public String refreshToken(String token) {
		final Date createdDate = new Date();
		final Date expirationDate = calculateExpirationDate(createdDate);

		final Claims claims = getAllClaimsFromToken(token);
		claims.setIssuedAt(createdDate);
		claims.setExpiration(expirationDate);

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, config.getSecret()).compact();
	}

	@Override
	public Boolean validateToken(String token, UserDetails userDetails) {
		UserAccount user = (UserAccount) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + config.getExpirationTime() * 1000);
	}

	@Override
	public void invalidateToken(String token, User u) {
		tokensDao.create(new InvalidTokens(token, u));
	}

	@Override
	public InvalidTokens findTokenByValue(String value) {
		return tokensDao.findByValue(value);
	}

	@Override
	public InvalidTokens findTokenByUser(String value) {
		return tokensDao.findByUsername(value);
	}
}
