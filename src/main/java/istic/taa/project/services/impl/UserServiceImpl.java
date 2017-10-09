package istic.taa.project.services.impl;

import istic.taa.project.dao.IUserDao;
import istic.taa.project.model.User;
import istic.taa.project.services.IUserService;
import istic.taa.project.wrappers.UserWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	public UserWrapper authenticate(String username, String pwd) {
		User u = this.userDao.getUserByCredential(username, pwd);
		return new UserWrapper(u);
	}

	@Override
	public UserWrapper create(String username, String password, String mail) {
		User u = new User(username, password, mail);
		userDao.create(u);
		return new UserWrapper(u);
	}

	@Override
	public String requestDeletion(String username, String mail) {
		User u = userDao.getUserByMailAndUsername(username, mail);
		if (u != null) {
			boolean result = userDao.updateDeletionCode(u);
			if (result) {
				return "ok";
			}
		}
		return "ko";
	}
}
