package istic.taa.project.services;

import istic.taa.project.wrappers.CheckElementWrapper;

public interface IValidationService {
	public CheckElementWrapper checkEMail(String email);
	public CheckElementWrapper checkUsername(String username);
}
