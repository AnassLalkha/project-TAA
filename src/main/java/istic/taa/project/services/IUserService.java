package istic.taa.project.services;
import java.util.List;

import istic.taa.project.model.FavouriteActivity;
import istic.taa.project.wrappers.UserWrapper;

public interface IUserService {
	public UserWrapper authenticate(String username, String pwd);
	public UserWrapper create(String username, String password, String mail);
	public String requestDeletion(String username, String mail);
	public List<FavouriteActivity> getFavouriteActivities(String username, String email);
}
