package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.USER_INPUT_ONE;
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
		String[] userInputs = {USER_INPUT_ONE, USER_INPUT_ONE, USER_INPUT_ONE};
		
		assertTrue(gameExecutor.isUserInputInvalid(userInputs));
	}

}