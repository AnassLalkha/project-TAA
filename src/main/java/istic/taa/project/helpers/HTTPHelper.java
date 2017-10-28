package istic.taa.project.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class HTTPHelper {
	private static HTTPHelper instance;
	private static final Logger LOG = Logger.getLogger(HTTPHelper.class);

	public static HTTPHelper getInstance() {
		if (instance == null) {
			instance = new HTTPHelper();
		}
		return instance;
	}

	private HTTPHelper() {

	}

	public String get(String endpoint) {
		LOG.debug("Get request on endpoint : " + endpoint);
		StringBuilder result = new StringBuilder();
		URL url = null;
		try {
			url = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			LOG.debug("response from endpoint : " + result.toString());
			return result.toString();
		} catch (MalformedURLException e) {
			LOG.error("trying to make get http request on wrong url " + endpoint, e);
		} catch (IOException e) {
			LOG.error("Io exception appeared when making get http request on " + endpoint, e);
		}
		return null;

	}
}
