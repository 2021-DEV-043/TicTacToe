package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameTest {

	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		TicTacToeGame game = new TicTacToeGame();
		game.placeMoveOnTheBoard(1, 1, 'X');

		assertEquals('X', game.identifyPlayerAt(1, 1));
	}

}