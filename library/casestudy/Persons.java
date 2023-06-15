package com.test.library.casestudy;

//Java Program to Illustrate Persons Class
//To Do all the Operations related to Persons:
//add Person,check-in books,check out books,Validperson
import java.util.Scanner;

public class Persons {

	// Creating objects of Scanner and persons class
    Scanner input = new Scanner(System.in);
    Person thePersons[] = new Person[10];
    
    public static int count = 0;
    
    //add person
    public void addPerson(Person p) {
    	for(int i =0; i < count; i++) {
    		if(p.telephoneNumber.equalsIgnoreCase(thePersons[i].telephoneNumber)) {
    			System.out.println("Person of Telephone Number " + p.telephoneNumber +" is Already Registered.");
                return;
    		}
    	}
    	
    	if (count <= 10) {
            thePersons[count] = p;
            count++;
        }
    }
    
    // To check the person
    public int isPerson()
    {
        // Display message only
        System.out.println("Enter Telephone Number:");
        String telephoneNum = input.nextLine();
        for (int i = 0; i < count; i++) {
 
            if (thePersons[i].telephoneNumber.equalsIgnoreCase(telephoneNum)) {
                return i;
            }
        }
 
        // Print statements
        System.out.println("Person is not Registered.");
        System.out.println("Get Registered First.");
 
        return -1;
    }
    
 // Displaying all persons
    public void showAllPersons()
    {
        // Printing person name and
        // corresponding registered number
        System.out.println("Person Name\t\tTele Number");
        for (int i = 0; i < count; i++) {
            System.out.println(thePersons[i].personName
                               + "\t\t"
                               + thePersons[i].telephoneNumber);
        }
    }
 
    // To add the book
    public void addPersonBook(Books book)
    {
        int personIndex = this.isPerson();
        if (personIndex != -1) {
 
            // Printing credentials corresponding to person
            System.out.println(
                "S.No\t\t\tBook Name\t\t\tAuthor Name");
 
            Person p = thePersons[personIndex];
 
            for (int i = 0; i < p.booksCount; i++) {
 
                System.out.println(
                    p.borrowedBooks[i].isbnNumber + "\t\t\t"
                    + p.borrowedBooks[i].title + "\t\t\t"
                    + p.borrowedBooks[i].authorName);
            }
 
            // Display message only
            System.out.println(
                "Enter ISBN Number of Book to be Checked In:");
 
            int isbnNumber = input.nextInt();
 
            for (int i = 0; i < p.booksCount; i++) {
                if (isbnNumber == p.borrowedBooks[i].isbnNumber) {
                    book.addLibraryBook(p.borrowedBooks[i]);
                    p.borrowedBooks[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Book of ISBN Number " + isbnNumber
                               + "not Found");
        }
    }
    
    // To remove the book
    public void removePersonBook(Books book)
    {
        int personIndex = this.isPerson();
 
        if (personIndex != -1) {
            System.out.println("checking out");
 
            book.showAllBooks();
            Book b = book.removeLibraryBook();
 
            System.out.println("checking out");
            if (b != null) {
 
                if (thePersons[personIndex].booksCount
                    <= 6) {
 
                    System.out.println("adding book");
                    thePersons[personIndex].borrowedBooks
                        [thePersons[personIndex]
                             .booksCount]
                        = b;
                    thePersons[personIndex].booksCount++;
 
                    return;
                }
                else {
 
                    System.out.println(
                        "person Can not Borrow more than 6 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
    
 
}
