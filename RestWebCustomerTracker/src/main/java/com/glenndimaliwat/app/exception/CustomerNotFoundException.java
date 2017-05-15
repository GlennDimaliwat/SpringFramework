package com.glenndimaliwat.app.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5341012457364849640L;

	public CustomerNotFoundException( String msg ) {
		super(msg);
	}
}
