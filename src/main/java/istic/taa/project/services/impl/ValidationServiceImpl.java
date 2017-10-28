package istic.taa.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import istic.taa.project.constants.Operations;
import istic.taa.project.dao.IUserDao;
import istic.taa.project.services.IValidationService;
import istic.taa.project.wrappers.CheckElementWrapper;

@Component
public class ValidationServiceImpl implements IValidationService {

	@Autowired
	private IUserDao userDao;

	@Override
	public CheckElementWrapper checkEMail(String email) {
		String status = "ok";
		boolean result = false;
		try {
			result = userDao.checkEmailExists(email);
		} catch (Exception e) {
			status = "ko";
		}
		return new CheckElementWrapper(email, result, status, Operations.CHECK_EMAIL);
	}

	@Override
	public CheckElementWrapper checkUsername(String username) {
		String status = "ok";
		boolean result = false;
		try {
			result = userDao.checkUsernameExists(username);
		} catch (Exception e) {
			status = "ko";
		}
		return new CheckElementWrapper(username, result, status, Operations.CHECK_USERNAME);
	}

}
