package com.test;

public class CustomException {

	public static void main(String args[]) throws CreateException {
		// Throwing the custom exception be passing the message
		throw new CreateException(" This is my custom Exception ");
	}
}

// Creating Custom Exception Class
class CreateException extends Exception {
	// Defining Constructor to throw exception message
	public CreateException(String message){
            super(message);
        }
}
