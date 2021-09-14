package com.jhonchrizel.usersapi.exceptions;

public class UsersApiException extends Exception {

	
	private static final long serialVersionUID = -1559038053301851613L;
	public static final String EMPTY_DATABASE = "Error: Could not retrieve records. Database is empty.";
	public static final String NO_RECORDS_FOUND = "Error: No record(s) found in the database for this data: ";

	public UsersApiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsersApiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
