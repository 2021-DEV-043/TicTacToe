package com.bnppf.tdd.tictactoe.game;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameBoard {

	private static final int BOARD_SIZE = 3;
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';

	private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private char currentPlayer;

	public void placeMoveOnTheBoard(int row, int column) {
		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	public char identifyPlayerAt(int row, int column) {
		return board[row][column];
	}

	public char getNextPlayer() {
		return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
	}

}
