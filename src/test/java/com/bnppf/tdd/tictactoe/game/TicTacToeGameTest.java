package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameTest {

	private static final int POSITION_ONE = 1;
	private static final char PLAYER_X = 'X';
	
	@Autowired
	private TicTacToeGame game;
	
	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		game.placeMoveOnTheBoard(POSITION_ONE, POSITION_ONE, PLAYER_X);

		assertEquals(PLAYER_X, game.identifyPlayerAt(POSITION_ONE, POSITION_ONE));
	}
	
	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() {
		assertAll(() -> assertEquals(PLAYER_X, game.getNextPlayer('O')),
				() -> assertEquals('O', game.getNextPlayer(PLAYER_X)));
	}

}