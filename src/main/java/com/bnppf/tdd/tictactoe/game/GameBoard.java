package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_COLUMN_SEPARATOR;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_LOWER_RANGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_ROW_SEPARATOR;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_SIZE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_UPPER_RANGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.EMPTY_POSITION;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_TWO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.LINE_SEPARATOR;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.MAX_NUMBER_OF_POSITIONS;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.PLAYER_O;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.PLAYER_X;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.model.Position;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameBoard {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameBoard.class);
	
	private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private char currentPlayer;
	private int moveCount = INDEX_ZERO;

	public void placeMoveOnTheBoard(Position position) {
		currentPlayer = getNextPlayer();
		board[position.getRow()][position.getColumn()] = currentPlayer;
		moveCount++;
	}

	public char identifyPlayerAt(Position position) {
		return board[position.getRow()][position.getColumn()];
	}

	public char getNextPlayer() {
		return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
	}
	
	public boolean isPositionOutOfRange(Position position) {
		return (position.getRow() < BOARD_LOWER_RANGE || position.getRow() > BOARD_UPPER_RANGE || position.getColumn() < BOARD_LOWER_RANGE || position.getColumn() > BOARD_UPPER_RANGE);
	}
	
	public boolean isPositionOccupied(Position position) {
		return board[position.getRow()][position.getColumn()] != EMPTY_POSITION;
	}
	
	public boolean isAnyRowOccupiedBySamePlayer() {
		boolean isRowOccupied = false;
		int row = INDEX_ZERO;

		while (isWithinBoardLimitAndNotOccupiedBySamePlayer(isRowOccupied, row)) {
			if (isOccupiedBySamePlayer(board[row][INDEX_ZERO], board[row][INDEX_ONE], board[row][INDEX_TWO])) {
				isRowOccupied = true;
			}
			row++;
		}

		return isRowOccupied;
	}
	
	public boolean isAnyColumnOccupiedBySamePlayer() {
		boolean isColumnOccupied = false;
		int column = INDEX_ZERO;

		while (isWithinBoardLimitAndNotOccupiedBySamePlayer(isColumnOccupied, column)) {
			if (isOccupiedBySamePlayer(board[INDEX_ZERO][column], board[INDEX_ONE][column], board[INDEX_TWO][column])) {
				isColumnOccupied = true;
			}
			column++;
		}

		return isColumnOccupied;
	}
	
	public boolean isTopLeftToBottomRightDiagonalOccupiedBySamePlayer() {
		return isOccupiedBySamePlayer(board[INDEX_ZERO][INDEX_ZERO], board[INDEX_ONE][INDEX_ONE], board[INDEX_TWO][INDEX_TWO]);
	}
	
	public boolean isTopRightToBottomLeftDiagonalOccupiedBySamePlayer() {
		return isOccupiedBySamePlayer(board[INDEX_ZERO][INDEX_TWO], board[INDEX_ONE][INDEX_ONE], board[INDEX_TWO][INDEX_ZERO]);
	}
	
	public boolean areAllPositionOnBoardOccupied() {
		return moveCount == MAX_NUMBER_OF_POSITIONS;
	}
	
	private boolean isOccupiedBySamePlayer(char position1, char position2, char position3) {
		return position1 != EMPTY_POSITION && position1 == position2 && position2 == position3;
	}

	private boolean isWithinBoardLimitAndNotOccupiedBySamePlayer(boolean isOccupiedFlag, int rowOrColumnIndex) {
		return !isOccupiedFlag && rowOrColumnIndex < BOARD_SIZE;
	}
	
	public void printGameBoard() {
		StringBuilder boardPrinter = new StringBuilder();
		boardPrinter.append(LINE_SEPARATOR).append(BOARD_ROW_SEPARATOR).append(LINE_SEPARATOR);

		for (int row = INDEX_ZERO; row < BOARD_SIZE; row++) {
			boardPrinter.append(BOARD_COLUMN_SEPARATOR).append(" ");
			for (int column = INDEX_ZERO; column < BOARD_SIZE; column++) {
				boardPrinter.append(board[row][column]).append(" ").append(BOARD_COLUMN_SEPARATOR).append(" ");
			}
			boardPrinter.append(LINE_SEPARATOR);
			boardPrinter.append(BOARD_ROW_SEPARATOR).append(LINE_SEPARATOR);
		}
		String gameBoardLayout = boardPrinter.toString();
		LOGGER.info(gameBoardLayout);
	}

}
