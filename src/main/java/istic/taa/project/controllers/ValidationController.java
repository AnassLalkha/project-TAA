package istic.taa.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import istic.taa.project.services.IValidationService;
import istic.taa.project.wrappers.CheckElementWrapper;

@CrossOrigin("*")
@RestController
public class ValidationController {
	@Autowired
	private IValidationService validationService;

	@RequestMapping("/interface/v1/perm/check-email")
	public CheckElementWrapper checkEmail(@RequestParam("value") String mail) {
		return validationService.checkEMail(mail);
	}

	@RequestMapping("/interface/v1/perm/check-username")
	public CheckElementWrapper checkUsername(@RequestParam("value") String username) {
		return validationService.checkUsername(username);
	}
}
