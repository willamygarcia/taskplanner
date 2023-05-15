package br.com.cobax.taskpanner.exceptions;

public class FieldNotBlankException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	public FieldNotBlankException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldNotBlankException(String message) {
		super(message);
	}

}
