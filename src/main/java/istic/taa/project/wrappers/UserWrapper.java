package istic.taa.project.wrappers;

import istic.taa.project.constants.Operations;
import istic.taa.project.model.User;

public class UserWrapper extends GenericWrapper {
	private User user;

	public UserWrapper(User u, Operations operation, String status) {
		super(operation.toString(), status);
		this.user = u;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
