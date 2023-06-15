package com.test;

public class ReverseString {

	public static void main(String[] args) {
		String str = "sandesh";
		int n = str.length();
		char[] revString = new char[n];
		
		// fill character array backward with characters in the string
        for (int i = 0; i < n; i++) {
        	revString[n - i - 1] = str.charAt(i);
        }
		
		System.out.println("Reverse String is= "+ String.valueOf(revString));

	}

}
