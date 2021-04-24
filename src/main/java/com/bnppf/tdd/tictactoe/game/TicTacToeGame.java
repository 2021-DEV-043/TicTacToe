package com.bnppf.tdd.tictactoe.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGame {

	@Autowired
	private GameBoard gameBoard;
	
	public void play(int row, int column) {
		gameBoard.placeMoveOnTheBoard(row, column);
	}

	public char identifyPlayerAt(int row, int column) {
		return gameBoard.identifyPlayerAt(row, column);
	}
	
	public char getNextPlayer() {
		return gameBoard.getNextPlayer();
	}

}
