package istic.taa.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import istic.taa.project.model.User;
import istic.taa.project.services.IUserService;
import istic.taa.project.wrappers.UserWrapper;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/interface/v1/authenticate")
	public UserWrapper authenticate(@RequestBody User u) {
		return userService.authenticate(u.getUsername(), u.getPassword());
	}

	@RequestMapping("/interface/v1/create")
	public UserWrapper create(@RequestBody User u) {
		return userService.create(u.getUsername(), u.getPassword(), u.getEmail());
	}

	@RequestMapping("/interface/v1/request-deletion")
	public String requestDeletion(@RequestBody User u) {
		return userService.requestDeletion(u.getUsername(), u.getEmail());
	}
}
