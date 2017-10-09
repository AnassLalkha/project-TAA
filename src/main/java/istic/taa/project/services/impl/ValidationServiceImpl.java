package istic.taa.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import istic.taa.project.dao.IUserDao;
import istic.taa.project.services.IValidationService;
import istic.taa.project.wrappers.CheckElementWrapper;

@Component
public class ValidationServiceImpl implements IValidationService{
	
	@Autowired
	private IUserDao userDao;
	@Override
	public CheckElementWrapper checkEMail(String email) {
		boolean result = userDao.checkEmailExists(email);
		return new CheckElementWrapper(email, result);
	}

	@Override
	public CheckElementWrapper checkUsername(String username) {
		boolean result = userDao.checkUsernameExists(username);
		return new CheckElementWrapper(username, result);
	}

}
