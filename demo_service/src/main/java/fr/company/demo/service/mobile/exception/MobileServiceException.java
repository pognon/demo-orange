package fr.company.demo.service.mobile.exception;


public class MobileServiceException extends Exception{

	private static final long serialVersionUID = -7247635374552818153L;

	public MobileServiceException() {
		super();
	}

	public MobileServiceException(String message) {
		super(message);
	}

	public MobileServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MobileServiceException(Throwable cause) {
		super(cause);
	}

}
