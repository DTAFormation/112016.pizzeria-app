package fr.pizzeria.admin.exception;

import java.security.NoSuchAlgorithmException;

public class ClientException extends Exception {

	public ClientException(NoSuchAlgorithmException exception) {
		super(exception);
	}

}
