package fr.company.demo.service.mobile.exception;


public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 4582613893508687000L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable t) {
		super(message, t);
	}
}
