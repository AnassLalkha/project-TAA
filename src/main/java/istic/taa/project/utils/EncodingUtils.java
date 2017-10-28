package istic.taa.project.utils;

import istic.taa.project.constants.Constants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class EncodingUtils {
	private static final Logger LOG = Logger.getLogger(EncodingUtils.class);
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
        }
        catch (NoSuchAlgorithmException md) {
        	LOG.error("Unable to encode the password", md);
        }
        return hashtext;
    }
}

