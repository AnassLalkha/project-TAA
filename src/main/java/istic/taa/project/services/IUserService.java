package istic.taa.project.services;
import istic.taa.project.wrappers.UserWrapper;

public interface IUserService {
	public UserWrapper authenticate(String username, String pwd);
	public UserWrapper create(String username, String password, String mail);
	public String requestDeletion(String username, String mail);
}
