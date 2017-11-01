package istic.taa.project.dao;

import istic.taa.project.model.InvalidTokens;

public interface IInvalidTokensDao extends IGenericDao<InvalidTokens> {
	public InvalidTokens findByValue(String value);

	public InvalidTokens findByUsername(String value);
}
