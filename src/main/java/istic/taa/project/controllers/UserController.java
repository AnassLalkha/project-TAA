package istic.taa.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import istic.taa.project.model.FavouriteActivity;
import istic.taa.project.model.FavouriteLocation;
import istic.taa.project.model.User;
import istic.taa.project.security.UserAccount;
import istic.taa.project.services.IUserService;
import istic.taa.project.services.impl.TokenServiceImpl;
import istic.taa.project.utils.UserFactory;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.UserWrapper;

@RestController
public class UserController {
	@Autowired
	TokenServiceImpl jwtUtil;
	@Autowired
	private IUserService userService;

	@RequestMapping("/interface/v1/auth/get-favourite-activities")
	public List<FavouriteActivity> favouriteActivities(@RequestBody User user) {
		return userService.getFavouriteActivities(user.getUsername(), user.getEmail());
	}

	@RequestMapping("/interface/v1/perm/logout")
	public GenericWrapper logout(@RequestParam String username) {
		return userService.logout(username);
	}

	@RequestMapping("/intefrace/v1/auth/get-favourite-locations")
	public List<FavouriteLocation> favouriteLocations(@RequestBody User user) {
		return userService.getFavouriteLocations(user.getUsername(), user.getEmail());
	}

	@RequestMapping("/interface/v1/perm/authenticate")
	public UserWrapper authenticate(@RequestBody User u, Device device) {
		UserWrapper uw = userService.authenticate(u.getUsername(), u.getPassword());
		if (uw.getUser() != null) {
			UserAccount ua = UserFactory.create(uw.getUser());
			uw.setToken(jwtUtil.generateToken(ua, device));
		}
		return uw;
	}

	@RequestMapping("/interface/v1/perm/create")
	public UserWrapper create(@RequestBody User u, Device device) {
		UserWrapper uw = userService.create(u.getUsername(), u.getPassword(), u.getEmail());
		if (uw.getUser() != null) {
			UserAccount ua = UserFactory.create(uw.getUser());
			uw.setToken(jwtUtil.generateToken(ua, device));
		}
		return uw;
	}

	@RequestMapping("/interface/v1/auth/request-deletion")
	public GenericWrapper requestDeletion(@RequestBody User u) {
		return userService.requestDeletion(u.getUsername(), u.getEmail());
	}
}
