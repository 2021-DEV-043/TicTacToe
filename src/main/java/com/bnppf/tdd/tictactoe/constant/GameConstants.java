package com.bnppf.tdd.tictactoe.constant;

public final class GameConstants {
	
	private GameConstants() {

	}

	public static final int BOARD_SIZE = 3;
	public static final char PLAYER_X = 'X';
	public static final char PLAYER_O = 'O';
	public static final char EMPTY_POSITION = '\0';
	
	public static final int BOARD_LOWER_RANGE = 0;
	public static final int BOARD_UPPER_RANGE = 2;
	
	public static final int INDEX_ZERO = 0;
	public static final int INDEX_ONE = 1;
	public static final int INDEX_TWO = 2;
	
	public static final String POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE = "Invalid Position..!! Please provide a valid position within a range of 0 to 2";
	public static final String POSITION_OCCUPIED_EXCEPTION_MESSAGE = "Position is already occupied by other player. Please choose a different position.";
}
