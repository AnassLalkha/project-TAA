package istic.taa.project.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@Component
public class AppConfig {

	@Value("${security.jwt.default.role}")
	private String role;
	@Value("security.jwt.default.password")
	private String password;
	@Value("${security.jwt.default.username}")
	private String username;
	@Value("${security.jwt.secret}")
	private String secret;
	@Value("${security.jwt.prefix}")
	private String prefix;
	@Value("${security.jwt.expiration.time}")
	private Long expirationTime;
	@Value("${security.logout.url}")
	private String logoutUrl;
	@Value("${security.jwt.header}")
	private String headerName;
	@Value("${security.jwt.username.suffix}")
	private String usernameSuffix;
	@Value("${default.notification.username")
	private String defaultNotificationUsername;

	public String getDefaultNotificationUsername() {
		return defaultNotificationUsername;
	}

	public String getDefaultNotificationPwd() {
		return defaultNotificationPwd;
	}

	@Value("${default.notification.password")
	private String defaultNotificationPwd;

	public String getUsernameSuffix() {
		return usernameSuffix;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public String getHeaderName() {
		return headerName;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getSecret() {
		return secret;
	}

	public String getPrefix() {
		return prefix;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}
}
