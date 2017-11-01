package istic.taa.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import istic.taa.project.services.IValidationService;
import istic.taa.project.wrappers.CheckElementWrapper;

@RestController
public class ValidationController {
	@Autowired
	private IValidationService validationService;

	@RequestMapping("/interface/v1/perm/check-email")
	public CheckElementWrapper checkEmail(@RequestParam("email") String mail) {
		return validationService.checkEMail(mail);
	}

	@RequestMapping("/interface/v1/perm/check-username")
	public CheckElementWrapper checkUsername(@RequestParam("username") String username) {
		return validationService.checkUsername(username);
	}
}
