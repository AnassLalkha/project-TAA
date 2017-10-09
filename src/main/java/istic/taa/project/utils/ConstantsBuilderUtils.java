package istic.taa.project.utils;

import istic.taa.project.exceptions.TechnicalException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConstantsBuilderUtils {
	private Properties props = null;
	private static ConstantsBuilderUtils instance = null;
	private static final String PROPS_FILE = "/props.properties";
	private static final Logger LOG = Logger.getLogger(ConstantsBuilderUtils.class);

	private ConstantsBuilderUtils() {
		try {
			InputStream is = ClassLoader.class.getResourceAsStream(PROPS_FILE);
			if (is != null) {
				this.props = new Properties();
				this.props.load(is);
			}
		} catch (FileNotFoundException e) {
			LOG.error("unable to find the properties file");
			throw new TechnicalException("Fatal error => something went wrong", e);
		} catch (IOException e) {
			LOG.error("unable to load the properties file");
			throw new TechnicalException("Fatal error => something went wrong", e);
		}
	}

	public static ConstantsBuilderUtils getInstance() {
		if (instance == null) {
			instance = new ConstantsBuilderUtils();
		}
		return instance;
	}

	public String getPropsByKey(String key) {
		return this.props.getProperty(key);
	}
}
