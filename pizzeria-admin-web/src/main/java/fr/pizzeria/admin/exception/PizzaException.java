package fr.pizzeria.admin.exception;

public class PizzaException extends RuntimeException {

	public PizzaException() {
		super();
	}

	public PizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PizzaException(String message) {
		super(message);
	}

	public PizzaException(Throwable cause) {
		super(cause);
	}

	
}
