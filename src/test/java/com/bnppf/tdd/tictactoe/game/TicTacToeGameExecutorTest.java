package com.bnppf.tdd.tictactoe.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicTacToeGameExecutorTest {

	@Test
	@DisplayName("Declare user input as invalid if user provides input of length other than two")
	public void declareUserInputasInvalidIfUserProvidesInputOfLengthOtherThanTwo() {
		TicTacToeGameExecutor gameExecutor = new TicTacToeGameExecutor();
		String[] userInputs = {"1", "1", "1"};
		
		assertTrue(gameExecutor.isUserInputInvalid(userInputs));
	}

}