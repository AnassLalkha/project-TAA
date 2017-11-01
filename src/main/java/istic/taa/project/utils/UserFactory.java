package istic.taa.project.utils;

import java.util.Collections;

import istic.taa.project.model.User;
import istic.taa.project.security.UserAccount;

public final class UserFactory {

	private UserFactory() {
	}

	public static UserAccount create(User user) {
		if (user != null) {
			return new UserAccount(user.getIdentifier(), user.getUsername(), user.getEmail(), user.getPassword(),
					Collections.emptyList(), user.isValidatedMail());
		}
		return null;
	}
}
