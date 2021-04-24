package com.bnppf.tdd.tictactoe.constant;

public final class GameConstants {
	
	private GameConstants() {

	}

	public static final int BOARD_SIZE = 3;
	public static final char PLAYER_X = 'X';
	public static final char PLAYER_O = 'O';
	
	public static final int BOARD_LOWER_RANGE = 0;
	public static final int BOARD_UPPER_RANGE = 2;
	
	public static final String POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE = "Invalid Position..!! Please provide a valid position within a range of 0 to 2";
}
