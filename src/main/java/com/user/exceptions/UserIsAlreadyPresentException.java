package com.user.exceptions;

public class UserIsAlreadyPresentException extends Exception{
	
	public UserIsAlreadyPresentException() {}
	public UserIsAlreadyPresentException(String m) {
		super(m);
	}
	public UserIsAlreadyPresentException(Exception e) {
		super(e);
	}
	public UserIsAlreadyPresentException(String m, Exception e) {
		super(m,e);
	}

}
