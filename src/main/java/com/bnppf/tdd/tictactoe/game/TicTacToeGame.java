package com.bnppf.tdd.tictactoe.game;

import org.springframework.stereotype.Component;

@Component
public class TicTacToeGame {

	private static final int BOARD_SIZE = 3;
	
	private char[][] gameBoard = new char[BOARD_SIZE][BOARD_SIZE];

	public void placeMoveOnTheBoard(int row, int column, char player) {
		gameBoard[row][column] = player;
	}

	public char identifyPlayerAt(int row, int column) {
		return gameBoard[row][column];
	}

}
