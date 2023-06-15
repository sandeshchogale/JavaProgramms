package com.test.library.casestudy;

import java.util.Scanner;

//Java Program to Illustrate book Class that
//takes Input from the books and related information
public class Book {
	// Class data members
	public int isbnNumber;
	public String title;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;

	// read input from users
    Scanner input = new Scanner(System.in);
    
    //method
	// To add book details
	public Book()
    {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("ISBN Number of Book:");
        this.isbnNumber = input.nextInt();
        input.nextLine();
 
        System.out.println("Enter Book Title:");
        this.title = input.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();
 
        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }

}
