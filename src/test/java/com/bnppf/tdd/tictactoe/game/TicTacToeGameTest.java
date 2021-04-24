package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameTest {

	private static final int POSITION_ONE = 1;
	private static final char PLAYER_X = 'X';
	
	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		TicTacToeGame game = new TicTacToeGame();
		game.placeMoveOnTheBoard(POSITION_ONE, POSITION_ONE, PLAYER_X);

		assertEquals(PLAYER_X, game.identifyPlayerAt(POSITION_ONE, POSITION_ONE));
	}

}