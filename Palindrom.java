package com.test;

import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println("Is "+word+" palindrome? - "+isWordPalindrome(word));
		

	}
	
	public static boolean isWordPalindrome(String word) {
		String reverseWord = getReverseWord(word);
		
		if(reverseWord.equals(word)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static String getReverseWord(String word) {
		if(null == word || word.isEmpty()) {
			return word;
		}
		
		return word.charAt(word.length() - 1) + getReverseWord(word.substring(0, word.length() - 1));
	}

}
