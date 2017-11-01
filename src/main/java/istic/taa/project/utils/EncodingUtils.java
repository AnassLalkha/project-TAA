package istic.taa.project.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import istic.taa.project.constants.Constants;

public class EncodingUtils {
	private static final Logger LOG = Logger.getLogger(EncodingUtils.class);
	private static final String PATTERN_0 = "$0";
	private static final String PATTERN_1 = "$1";

	private EncodingUtils() {
	}

	public static String encode(String rawStr) {
		String hashtext = "";
		byte[] saltString = (rawStr + Constants.SALT).getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(saltString);
			byte[] result = md.digest();
			BigInteger i = new BigInteger(1, result);
			hashtext = i.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException md) {
			LOG.error("Unable to encode the password", md);
		}
		return hashtext;
	}

	public static String encodeUsername(String username, String suffix, String staticSuffix) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder sb = new StringBuilder(username)
				.append(suffix.replace(PATTERN_0, sdf.format(now)).replace(PATTERN_1, staticSuffix));

		return sb.toString();
	}

	public static String decodeUsername(String encodedUsername) {
		String[] tab = encodedUsername.split(":");
		if (tab.length > 1) {
			return tab[0];
		}
		LOG.error("unable to decode username");
		throw new IllegalArgumentException("encoded username " + encodedUsername + " cannot be decoded");
	}
}
