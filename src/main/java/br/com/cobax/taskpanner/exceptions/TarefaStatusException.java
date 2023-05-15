package br.com.cobax.taskpanner.exceptions;

public class TarefaStatusException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TarefaStatusException() {
		super();
	}

	public TarefaStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public TarefaStatusException(String message) {
		super(message);
	}
	
}
