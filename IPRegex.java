package com.test;

import java.util.Scanner;

class IPRegex {
	
	/*
	 * 000.12.12.034 
	 * 121.234.12.12 
	 * 23.45.12.56 
	 * 00.12.123.123
	 * 123.123 
	 * 122.23 
	 * Hello.IP
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new myRegex().pattern));
		}

	}
}

class myRegex {
	public String pattern = "([1][\\d][\\d]|[0][0][0]|([0][0]|)[\\d]|([0]|)[\\d][\\d]|[2][0-4][\\d]|[2][5][0-5])."
			+ "([1][\\d][\\d]|[0][0][0]|([0][0]|)[\\d]|([0]|)[\\d][\\d]|[2][0-4][\\d]|[2][5][0-5])."
			+ "([1][\\d][\\d]|[0][0][0]|([0][0]|)[\\d]|([0]|)[\\d][\\d]|[2][0-4][\\d]|[2][5][0-5])."
			+ "([1][\\d][\\d]|[0][0][0]|([0][0]|)[\\d]|([0]|)[\\d][\\d]|[2][0-4][\\d]|[2][5][0-5])";

}

