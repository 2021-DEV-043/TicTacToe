package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.exception.PositionOutOfRangeException;
import com.bnppf.tdd.tictactoe.model.Position;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGame {

	@Autowired
	private GameBoard gameBoard;
	
	public void play(Position position) throws PositionOutOfRangeException {
		if (gameBoard.isPositionOutOfRange(position)) {
			throw new PositionOutOfRangeException(POSITION_OUT_OF_RANGE_EXCEPTION_MESSAGE);
		}
		
		gameBoard.placeMoveOnTheBoard(position);
	}

	public char identifyPlayerAt(Position position) {
		return gameBoard.identifyPlayerAt(position);
	}
	
	public char getNextPlayer() {
		return gameBoard.getNextPlayer();
	}

}
