package istic.taa.project.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IUserDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.User;
import istic.taa.project.utils.EncodingUtils;
import istic.taa.project.utils.RandomUtils;

@Component
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {
	private static final String GET_USER_BY_CREDENTIALS_QUERY = "FROM User user WHERE user.username = :u AND user.password = :pwd";
	private static final String GET_USER_BY_MAIL_AND_USERNAME_QUERY = "FROM User user WHERE user.email = :e AND user.username = :u";
	private static final String CHECK_EMAIL_EXISTS_QUERY = "FROM User user WHERE user.email = :e";
	private static final String GET_USER_BY_USERNAME = "FROM User user WHERE user.username = :u";
	private static final String GET_USER_BY_VALIDATION_CODE = "FROM User user WHERE user.validationCode = :vc";
	private boolean tryToSync = true;

	@Override
	public User getUserByCredential(String username, String password) {
		Query query = EntityManagerHelper.createHqlQuery(GET_USER_BY_CREDENTIALS_QUERY);
		query.setParameter("u", username);
		query.setParameter("pwd", EncodingUtils.encode(password));
		if (!query.getResultList().isEmpty()) {
			return (User) query.getResultList().get(0);
		}
		return null;
	}

	@Override
	public void create(User obj) {
		String pwd = obj.getPassword();
		obj.setPassword(EncodingUtils.encode(pwd));
		super.create(obj);
	}

	@Override
	public User getUserByMailAndUsername(String username, String email) {
		Query query = EntityManagerHelper.createHqlQuery(GET_USER_BY_MAIL_AND_USERNAME_QUERY);
		query.setParameter("e", email);
		query.setParameter("u", username);
		if (!query.getResultList().isEmpty()) {
			return (User) query.getResultList().get(0);
		}
		return null;
	}

	@Override
	public boolean updateDeletionCode(User u) {
		String deletionCode = RandomUtils.generateRandom();
		try {
			u.setDeletionCode(deletionCode);
			update(u);
			return true;
		} catch (Exception e) {
			String str = "Unable to update user with a new deletion code : user " + u + "deletion code" + deletionCode;
			LOG.debug(str);
			return false;
		}
	}

	@Override
	public boolean checkEmailExists(String email) {
		Query query = EntityManagerHelper.createHqlQuery(CHECK_EMAIL_EXISTS_QUERY);
		query.setParameter("e", email);
		return !query.getResultList().isEmpty();
	}

	@Override
	public boolean checkUsernameExists(String username) {
		Query query = EntityManagerHelper.createHqlQuery(GET_USER_BY_USERNAME);
		query.setParameter("u", username);
		return !query.getResultList().isEmpty();

	}

	@Override
	public User findUserByUsername(String username) {
		Query query = EntityManagerHelper.createHqlQuery(GET_USER_BY_USERNAME);
		query.setParameter("u", username);
		if (!query.getResultList().isEmpty()) {
			return (User) query.getResultList().get(0);
		} else if (tryToSync) {
			// manage the synchronisation
			EntityManagerHelper.close();
			tryToSync = false;
			findUserByUsername(username);
		}
		return null;

	}

	@Override
	public User findUserByValidationCode(String validationCode) {
		Query query = EntityManagerHelper.createHqlQuery(GET_USER_BY_VALIDATION_CODE);
		query.setParameter("vc", validationCode);
		if (!query.getResultList().isEmpty()) {
			return (User) query.getResultList().get(0);
		}
		return null;
	}

}
