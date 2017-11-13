package istic.taa.project.constants;

public enum Operations {
	UPDATE_WEATHER("UPDATING WEATHER"), REQUEST_DELETION("REQUEST DELETION CODE"), CREATE_USER(
			"CREATE USER"), AUTHENTICATION("AUTHENTICATION"), CHECK_EMAIL("CHECK PARAMETER EMAIL"), CHECK_USERNAME(
					"CHECK PARAMETER USERNAME"), FORECAST_WEATHER("GET FORCAST WEATHER"), CURRENT_WEATHER(
							"GET CURRENT WEATHER"), LOGOUT("LOGGING OUT"), GENERATION("GENERATE PROPOSAL");

	private String name;

	private Operations(String str) {
		name = str;
	}

	@Override
	public String toString() {
		return name;
	}

}
