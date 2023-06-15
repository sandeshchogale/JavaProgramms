package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramString {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// Input from two strings
		System.out.print("First String: ");
		String string1 = s.nextLine();
		
		System.out.print("Second String: ");
		String string2 = s.nextLine();

		//check for the length
		if (string1.length() == string2.length()) {
			// convert strings to char array
			char[] characterArray1 = string1.toCharArray();
			char[] characterArray2 = string2.toCharArray();
			// sort the arrays
			Arrays.sort(characterArray1);
			Arrays.sort(characterArray2);
			// check for equality, if found equal then anagram, else not an anagram
			boolean isAnagram = Arrays.equals(characterArray1, characterArray2);
			System.out.println("Anagram: " + isAnagram);

		}

	}
}