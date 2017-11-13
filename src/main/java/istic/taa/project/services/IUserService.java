package istic.taa.project.services;

import java.util.List;

import istic.taa.project.model.Activity;
import istic.taa.project.model.FavouriteLocation;
import istic.taa.project.model.User;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.UserWrapper;

public interface IUserService {
	public UserWrapper authenticate(String username, String pwd);

	public UserWrapper create(String username, String password, String mail);

	public GenericWrapper requestDeletion(String username, String mail);

	public List<Activity> getFavouriteActivities(String username, String email);

	public List<FavouriteLocation> getFavouriteLocations(String username, String email);

	public GenericWrapper logout(String username);

	public User findByUsername(String username);
}
