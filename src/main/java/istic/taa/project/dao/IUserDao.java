package istic.taa.project.dao;

import istic.taa.project.model.User;

public interface IUserDao extends IGenericDao<User> {
	public User getUserByCredential(String username, String passowrd);

	public User getUserByMailAndUsername(String username, String email);

	public boolean updateDeletionCode(User u);

	public boolean checkEmailExists(String email);

	public boolean checkUsernameExists(String username);

	public User findUserByUsername(String username);
}
