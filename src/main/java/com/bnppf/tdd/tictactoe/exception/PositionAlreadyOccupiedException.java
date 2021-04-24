package com.bnppf.tdd.tictactoe.exception;

public class PositionAlreadyOccupiedException extends Exception {

	private static final long serialVersionUID = 1L;

	public PositionAlreadyOccupiedException(String message) {
		super(message);
	}
}
