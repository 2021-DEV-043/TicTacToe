package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameTest {

	private static final int POSITION_ONE = 1;
	
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';
	
	@Autowired
	private TicTacToeGame game;
	
	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		game.placeMoveOnTheBoard(POSITION_ONE, POSITION_ONE);

		assertEquals(PLAYER_X, game.identifyPlayerAt(POSITION_ONE, POSITION_ONE));
	}
	
	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() {
		assertEquals(PLAYER_X, game.getNextPlayer());
		game.placeMoveOnTheBoard(POSITION_ONE, POSITION_ONE);
		
		assertEquals(PLAYER_O, game.getNextPlayer());
		
	}
	
	@Test
	@DisplayName("Game should switch players alternatively while playing")
	public void playersShouldBeSwitchedAlternativelyWhilePlaying() {
		game.placeMoveOnTheBoard(POSITION_ONE, POSITION_ONE);
		assertEquals(PLAYER_X, game.identifyPlayerAt(POSITION_ONE, POSITION_ONE));

		game.placeMoveOnTheBoard(0, 2);
		assertEquals(PLAYER_O, game.identifyPlayerAt(0, 2));
	}

}