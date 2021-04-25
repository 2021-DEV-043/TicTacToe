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
	public static final int MAX_NUMBER_OF_POSITIONS = 9;

	public static final int INDEX_ZERO = 0;
	public static final int INDEX_ONE = 1;
	public static final int INDEX_TWO = 2;
	
	public static final String POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE = "Invalid Position..!! Please provide a valid position within a range of 0 to 2";
	public static final String POSITION_OCCUPIED_EXCEPTION_MESSAGE = "Position is already occupied by other player. Please choose a different position.";
	public static final String INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE = "Invalid input format..!! Please pass the input in the format of row,column like 1,1";

	public static final String GAME_STARTED_MESSAGE = "Game Started";
	public static final String GAME_CONTINUE_MESSAGE = "Continue..!!";
	public static final String GAME_WINNER_MESSAGE = "Winner of the game is Player";
	public static final String GAME_DRAW_MESSAGE = "It's a Draw Game";
	public static final String GAME_ERROR_MESSAGE = "Error while playing game...!!";
	
	public static final String VALID_PATTERN = "\\d+";
	public static final int USER_INPUT_SIZE = 2;
	public static final String USER_INPUT_SEPARATOR = ",";
	
	public static final String GAMING_INSTRUCTION_ONE = "\nWelcome to Tic Tac Toe Game..!! \n";
	public static final String GAMING_INSTRUCTION_TWO = "Game proceeds by players alternatively placing X’s and O’s on the board \n";
	public static final String GAMING_INSTRUCTION_THREE = "Players to provide position in the format row,column as 0,2 \n";
	public static final String GAMING_INSTRUCTION_FOUR = "Game is continued till either of the below two conditions are meet \n";
	public static final String GAMING_INSTRUCTION_FIVE = "Until a winner can be concluded for which a player should be able to draw three X’s or three O’s in either of row, column or any diagonal\n";
	public static final String GAMING_INSTRUCTION_SIX = "Or game be declared as draw, If all nine squares are filled \n";
	public static final String GAMING_INSTRUCTION_SEVEN = "Player 'X' to start with the first move \n";
	public static final String GAMING_INSTRUCTION_EIGHT = "Player 'O' to follow.. \n";
	
	public static final String NEXT_PLAYER_INFORMATION = "Player '%s' to mark position(row,column) on the board now..";
	
	public static final String BOARD_ROW_SEPARATOR = "-------------";
	public static final String BOARD_COLUMN_SEPARATOR = "|";
	public static final String LINE_SEPARATOR = "\n";
}
