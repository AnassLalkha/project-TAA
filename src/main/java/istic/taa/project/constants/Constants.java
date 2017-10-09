package istic.taa.project.constants;

import istic.taa.project.utils.ConstantsBuilderUtils;

public class Constants {
	public static final String SALT = ConstantsBuilderUtils.getInstance().getPropsByKey("application.salt");

	// private constructor to make it not instanciable 
	private Constants() {

	}
}
