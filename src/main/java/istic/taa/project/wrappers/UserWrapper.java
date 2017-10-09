package istic.taa.project.wrappers;

import istic.taa.project.model.User;

public class UserWrapper {
	private User user;
	private String status;

	public UserWrapper(User u) {
		this.user = u;
		if (u == null) {
			status = "ko";
		} else {
			status = "ok";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
