package com.complexcity.test;

public class XShape {
	public static void main(String[] args) {
		int size = 8; // Set the size of the X shape to 8 rows and 8 columns

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i + j == size - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}









