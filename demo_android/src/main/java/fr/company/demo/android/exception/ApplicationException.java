package fr.company.demo.android.exception;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -833409127948115965L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	 
}

