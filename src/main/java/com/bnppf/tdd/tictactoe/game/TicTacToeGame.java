package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_CONTINUE_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_DRAW_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_WINNER_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.POSITION_OCCUPIED_EXCEPTION_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.exception.PositionAlreadyOccupiedException;
import com.bnppf.tdd.tictactoe.exception.PositionOutOfRangeException;
import com.bnppf.tdd.tictactoe.model.Position;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGame {

	@Autowired
	private GameBoard gameBoard;
	
	public String play(Position position) throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		String result = GAME_CONTINUE_MESSAGE;
		
		validatePlayingConditions(position);
		gameBoard.placeMoveOnTheBoard(position);
		
		if (isPlayerWinner()) {
			result = String.format("%s '%s'", GAME_WINNER_MESSAGE, gameBoard.identifyPlayerAt(position));
		} else if (isDraw()) {
			result = GAME_DRAW_MESSAGE;
		}
		return result;
	}

	public char identifyPlayerAt(Position position) {
		return gameBoard.identifyPlayerAt(position);
	}
	
	public char getNextPlayer() {
		return gameBoard.getNextPlayer();
	}
	
	public void printGameBoard() {
		gameBoard.printGameBoard();
	}
	
	private boolean isDraw() {
		return gameBoard.areAllPositionOnBoardOccupied();
	}
	
	private boolean isPlayerWinner() {
		return gameBoard.isAnyRowOccupiedBySamePlayer() || gameBoard.isAnyColumnOccupiedBySamePlayer()
				|| gameBoard.isTopLeftToBottomRightDiagonalOccupiedBySamePlayer()
				|| gameBoard.isTopRightToBottomLeftDiagonalOccupiedBySamePlayer();
	}
	
	private void validatePlayingConditions(Position position) throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		if (gameBoard.isPositionOutOfRange(position)) {
			throw new PositionOutOfRangeException(POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE);
		}
		if (gameBoard.isPositionOccupied(position)) {
			throw new PositionAlreadyOccupiedException(POSITION_OCCUPIED_EXCEPTION_MESSAGE);
		}
	}

}
