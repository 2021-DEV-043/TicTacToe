package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.BOARD_SIZE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.PLAYER_O;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.PLAYER_X;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.model.Position;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameBoard {

	private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private char currentPlayer;

	public void placeMoveOnTheBoard(Position position) {
		currentPlayer = getNextPlayer();
		board[position.getRow()][position.getColumn()] = currentPlayer;
	}

	public char identifyPlayerAt(Position position) {
		return board[position.getRow()][position.getColumn()];
	}

	public char getNextPlayer() {
		return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
	}
	
	public boolean isPositionOutOfRange(Position position) {
		return (position.getRow() < 0 || position.getRow() > 2 || position.getColumn() < 0 || position.getColumn() > 2);
	}

}