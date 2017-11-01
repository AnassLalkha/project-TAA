package istic.taa.project.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IInvalidTokensDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.InvalidTokens;

@Component
public class InvalidTokensDaoImpl extends GenericDaoImpl<InvalidTokens> implements IInvalidTokensDao {

	private static final String GET_TOKEN_BY_VALUE_QUERY = "FROM InvalidTokens token where value = :v";
	private static final String GET_TOKEN_BY_USERNAME_QUERY = "SELECT token FROM InvalidTokens token join token.user u where u.username = :u order by token.identifier desc";

	@Override
	public InvalidTokens findByValue(String value) {
		Query query = EntityManagerHelper.createHqlQuery(GET_TOKEN_BY_VALUE_QUERY);
		query.setParameter("v", value);
		if (!query.getResultList().isEmpty()) {
			Object obj = query.getResultList().get(0);
			return (InvalidTokens) obj;
		}
		return null;
	}

	@Override
	public InvalidTokens findByUsername(String value) {
		Query query = EntityManagerHelper.createHqlQuery(GET_TOKEN_BY_USERNAME_QUERY);
		query.setParameter("u", value);
		if (!query.getResultList().isEmpty()) {
			Object obj = query.getResultList().get(0);
			return (InvalidTokens) obj;
		}
		return null;
	}

}
