package com.bnppf.tdd.tictactoe.exception;

public class InvalidUserInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserInputException(String message) {
		super(message);
	}
}
