package istic.taa.project.constants;

import istic.taa.project.utils.ConstantsBuilderUtils;

public class Constants {
	public static final String SALT = ConstantsBuilderUtils.getInstance().getPropsByKey("application.salt");
	public static final String WEATHER_API_KEY = ConstantsBuilderUtils.getInstance().getPropsByKey("weather.api.key");
	public static final String WEATHER_ENDPOINT = ConstantsBuilderUtils.getInstance()
			.getPropsByKey("weather.api.endpoint");
	public static final String WEATHER_ENDPOINT_DAYS = ConstantsBuilderUtils.getInstance()
			.getPropsByKey("weather.endpoint.days");
	public static final String WEATHER_MODE_FORECAST = ConstantsBuilderUtils.getInstance()
			.getPropsByKey("weather.mode.forecast");
	public static final String WEATHER_MODE_CURRENT = ConstantsBuilderUtils.getInstance()
			.getPropsByKey("weather.mode.current");
	public static final String LOCATION_PARAMETER = "${APPLOC}";
	public static final String MODE_PARAMETER = "${MODE}";
	public static final String APPID_PARAMETER = "${APPKEY}";
	public static final String DAYS_PARAMETER = "${days}";
	public static final String SUBJECT_DELETE_ACCOUNT = "Delete your WEEKEND-ADVISOR account";
	public static final String SUBJECT_CONFIRM_ACCOUNT = "[WELECOM :) ] Confirm your email";

	// private constructor to make it not instanciable
	private Constants() {

	}
}
