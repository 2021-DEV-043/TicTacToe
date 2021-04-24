package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnppf.tdd.tictactoe.model.Position;

@SpringBootTest
public class GameBoardTest {

	private static final int POSITION_ZERO = 0;
	private static final int POSITION_ONE = 1;
	private static final int POSITION_TWO = 2;

	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';

	@Autowired
	private GameBoard gameBoard;

	@Test
	@DisplayName("Board to accept a move at a poistion from Player X")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position);

		assertEquals(PLAYER_X, gameBoard.identifyPlayerAt(position));
	}

	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() {
		assertEquals(PLAYER_X, gameBoard.getNextPlayer());
		
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position);
		
		assertEquals(PLAYER_O, gameBoard.getNextPlayer());
		
	}
	
	@Test
	@DisplayName("Players should be switched alternatively while placing moves on the board")
	public void playersShouldBeSwitchedAlternativelyWhilePlaying() {
		Position position1 = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position1);
		
		assertEquals(PLAYER_X, gameBoard.identifyPlayerAt(position1));

		Position position2 = new Position(POSITION_ZERO, POSITION_TWO);
		gameBoard.placeMoveOnTheBoard(position2);
		
		assertEquals(PLAYER_O, gameBoard.identifyPlayerAt(position2));
	}

}
