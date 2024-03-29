package ua.bieliaiev.busstation.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

	// Private constructor to static util class.
	private Randomizer () {}
	private static final Random r = ThreadLocalRandom.current();

	public static String getLetters(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append((char) (r.nextInt(26) + 'A'));
		}
		return builder.toString();
	}
	public static String getNumbers(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append(r.nextInt(10));
		}
		return builder.toString();
	}

	public static int getNumberBetween(int lower, int upper) {
		return r.nextInt(lower, upper);
	}
}
