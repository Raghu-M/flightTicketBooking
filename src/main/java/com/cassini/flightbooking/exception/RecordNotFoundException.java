package com.cassini.flightbooking.exception;

public class RecordNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String exception) {
        super(exception);
    }

}
