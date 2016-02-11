package org.bala.messenger.exceptions;

import org.bala.messenger.model.ErrorMessage;

public class DataNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorMessage errorMessage;
	
	public DataNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public DataNotFoundException(ErrorMessage errorMessage)
	{
		this.setErrorMessage(errorMessage);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}
