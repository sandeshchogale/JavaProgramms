package com.test.library.casestudy;

import java.util.Scanner;

//Java Program to Illustrate books class
//To Do all the Operations related to Books such as
//add, check-in, check-out,Valid books,Update books
public class Books {

	// Class data members
    Book theBooks[] = new Book[10];
    public static int count;
    Scanner input = new Scanner(System.in);
    
    
    //to compare books
    public int compareBooksObjects(Book b1, Book b2) {
    	//if book name is match
    	if(b1.title.equalsIgnoreCase(b2.title)) {
    		System.out.println("Book of this title is already exists.");
    		return 0;
    	}
    	if(b1.isbnNumber == b2.isbnNumber) {
    		System.out.println("Book of this isbn number is already exists.");
    		return 0;
    	}
    	return 1;
    }
    
    //to add book
    public void addBook(Book b) {
    	for(int i=0; i<count; i++) {
    		if(this.compareBooksObjects(b, theBooks[i]) == 0){
    			return;
    		}
    	}
    	
    	if(count < 10) {
    		theBooks[count] = b;
    		count++;
    	}else {
    		System.out.println("No Space to add books");
    	}
    }
    
    //to search book by ISBN Number
    public void searchBySno() {
    	System.out.println("\t\t\t\tSEARCH BY ISBN NUMBER\n");
    	
    	int sNo;
    	System.out.println("Enter ISBN Number of Book: ");
    	sNo = input.nextInt();
    	
    	int flag = 0;
    	System.out.println("ISBN Number\t\tTiltle\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    	
    	for(int i=0; i < count; i++) {
    		if(sNo == theBooks[i].isbnNumber) {
    			System.out.println(
                        theBooks[i].isbnNumber + "\t\t"
                        + theBooks[i].title + "\t\t"
                        + theBooks[i].authorName + "\t\t"
                        + theBooks[i].bookQtyCopy + "\t\t"
                        + theBooks[i].bookQty);
                    flag++;
                    return;
    		}
    	}
    	
    	if (flag == 0)
            System.out.println("No Book for ISBN Number "
                               + sNo + " Found.");
    	
    }
    
    // To search author by name
    public void searchByAuthorName()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
 
        input.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
 
        int flag = 0;
 
        System.out.println(
            "ISBN Number\t\tTitle\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            // if author matches any of its book
            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {
 
                // Print below corresponding credentials
                System.out.println(
                    theBooks[i].isbnNumber + "\t\t"
                    + theBooks[i].title + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
            }
        }
 
        // Else no book matches for author
        if (flag == 0)
            System.out.println("No Books of " + authorName
                               + " Found.");
    }
    
    // To display all books
    public void showAllBooks()
    {
 
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
            "ISBN Number\t\tTitle\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            System.out.println(
                theBooks[i].isbnNumber + "\t\t"
                + theBooks[i].title + "\t\t"
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
        }
    }
    
 // To edit the book
    public void upgradeBookQty()
    {
        System.out.println(
            "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter ISBN Number of Book");
        int sNo = input.nextInt();
 
        for (int i = 0; i < count; i++) {
 
            if (sNo == theBooks[i].isbnNumber) {
                // Display message
                System.out.println(
                    "Enter No of Books to be Added:");
 
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
 
                return;
            }
        }
    }
    
 // To search the library
    public int isAvailable(int isbnNumber)
    {
 
        for (int i = 0; i < count; i++) {
            if (isbnNumber == theBooks[i].isbnNumber) {
                if (theBooks[i].bookQtyCopy > 0) {
 
                    System.out.println(
                        "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No Book of ISBN Number "
                           + " Available in Library.");
        return -1;
    }
    
    // To remove the book from the library
    public Book removeLibraryBook()
    {
 
        System.out.println(
            "Enter ISBN Number of Book to be Checked Out.");
        int isbnNumber = input.nextInt();
 
        int bookIndex = isAvailable(isbnNumber);
 
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
    
    // To add the Book to the Library
    public void addLibraryBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
    
    
    // To create menu
    public void dispMenu()
    {
        // Displaying menu
        System.out.println(
            "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Person.");
        System.out.println("Press 6 to Show All Registered Person.");
        System.out.println("Press 7 to Remove Book from Account. ");
        System.out.println("Press 8 to Add Book in Account");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    
    
}
