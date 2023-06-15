package com.test.library.casestudy;

//Java Program to Illustrate Application CLass
//To Create The Menu For the Program

//Importing required classes
import java.util.Scanner;

//Class
public class Library {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println(
			"********************Welcome to the WeLoveBooks Library!********************");
		System.out.println(
			"				 Select From The Following Options:			 ");
		System.out.println(
			"**********************************************************************");

		// Creating object of book class
		Books books = new Books();
		// Creating object of students class
		Persons persons = new Persons();

		int choice;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {
			books.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

				// Case
			case 1:
				Book b = new Book();
				books.addBook(b);
				break;

				// Case
			case 2:
				books.upgradeBookQty();
				break;

			// Case
			case 3:

				System.out.println(
					" press 1 to Search with Book Serial No.");
				System.out.println(
					" Press 2 to Search with Book's Author Name.");
				searchChoice = input.nextInt();

				// Nested switch
				switch (searchChoice) {

					// Case
				case 1:
					books.searchBySno();
					break;

					// Case
				case 2:
					books.searchByAuthorName();
				}
				break;

				// Case
			case 4:
				books.showAllBooks();
				break;

				// Case
			case 5:
				Person p = new Person();
				persons.addPerson(p);
				break;

				// Case
			case 6:
				persons.showAllPersons();
				break;

				// Case
			case 7:
				persons.addPersonBook(books);
				break;

				// Case
			case 8:
				persons.removePersonBook(books);
				break;

				// Default case that will execute for sure
				// if above cases does not match
			default:
				System.out.println("ENTER BETWEEN 0 TO 8.");
			}

		}

		// Checking condition at last where we are
		// checking case entered value is not zero
		while (choice != 0);
	}
}

