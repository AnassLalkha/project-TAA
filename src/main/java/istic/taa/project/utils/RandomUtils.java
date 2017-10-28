package istic.taa.project.utils;

import java.util.Random;

public class RandomUtils {
	private RandomUtils() {
		
	}
	
	public static String generateRandom() {
		StringBuilder sb = new StringBuilder();
		Random rn = new Random();
		
		for(int i = 0; i <= 5; i++) {
			int j = rn.nextInt(9 - 0);
			sb.append(j);
		}
		return sb.toString();
	}
}
