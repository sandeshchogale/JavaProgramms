package com.test.library.casestudy;

import java.util.Scanner;

//to take Input from the person and related Information
public class Person {
	//To be a member of a library a person needs to register with the library using his telephone number. 
	public String personName;
	//Telephone number must be unique. 
	public String telephoneNumber;//unique

	//A person cannot loan more than 6 books.
	Book borrowedBooks[] = new Book[6];
	public int booksCount = 0;

	// Creating object of Scanner class to
	// take input from user
	Scanner input = new Scanner(System.in);

	// Constructor
	public Person()
	{
	    System.out.println("Enter Person Name:");
        // This keywords refers to current instance
        this.personName = input.nextLine();
	 
	    System.out.println("Enter Telephone Number:");
	    this.telephoneNumber = input.nextLine();
	}

}
