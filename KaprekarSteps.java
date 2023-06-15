package com.test;

import java.util.Arrays;

public class KaprekarSteps {

	public static int findStepsTo6174(int num) {
		if (num == 6174) {
			return 0;
		}

		int steps = 0;
		while (num != 6174) {
			int ascNum = getAscendingOrder(num);
			int descNum = getDescendingOrder(num);
			num = descNum - ascNum;
			steps++;

			if (num == 0) {
				return -1; // Exception case: All digits are the same
			}
		}

		return steps;
	}

	private static int getAscendingOrder(int num) {
		char[] digits = String.valueOf(num).toCharArray();
		Arrays.sort(digits);
		return Integer.parseInt(new String(digits));
	}

	private static int getDescendingOrder(int num) {
		char[] digits = String.valueOf(num).toCharArray();
		Arrays.sort(digits);
		StringBuilder sb = new StringBuilder(new String(digits));
		return Integer.parseInt(sb.reverse().toString());
	}

	public static void main(String[] args) {
		for (int num = 1000; num <= 9999; num++) {
			int steps = findStepsTo6174(num);
			if (steps != -1) {
				System.out.println("Number: " + num + ", Steps: " + steps);
			}
		}
	}
}
