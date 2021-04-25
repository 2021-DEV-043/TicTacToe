package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.GAME_WINNER_PLAYERX_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.USER_INPUT_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnppf.tdd.tictactoe.exception.InvalidUserInputException;

@SpringBootTest
public class TicTacToeGameExecutorTest {
	
	@Autowired
	private TicTacToeGameExecutor gameExecutor;

	@Test
	@DisplayName("Declare user input as invalid if user provides input of length other than two")
	public void declareUserInputasInvalidIfUserProvidesInputOfLengthOtherThanTwo() {
		String[] userInputs = {USER_INPUT_ONE, USER_INPUT_ONE, USER_INPUT_ONE};
		
		assertTrue(gameExecutor.isUserInputInvalid(userInputs));
	}
	
	@Test
	@DisplayName("Check if user input format is invalid")
	public void shouldReturnTrueIfUserInputFormatIsInvalid() {
		String[] userInputs = {USER_INPUT_ONE, ""};
		
		assertTrue(gameExecutor.isUserInputInvalid(userInputs));
	}
	
	@Test
	@DisplayName("Should throw an exception if users inputs are invalid")
	public void shouldThrowExceptionIfUserInputsAreInvalid() {
		String[] userInputs = {USER_INPUT_ONE, ""};
		assertThrows(InvalidUserInputException.class, () -> gameExecutor.validateUserInputs(userInputs));
	}
	
	@Test
	@DisplayName("Should declare a player as winner based upon user inputs")
	public void shouldDeclarePlayerAsWinnerBasedUponUserInputsFromCommandLine() {
		StringBuilder userInputBuilder = new StringBuilder("0,0").append("\n").append("1,1").append("\n")
				.append("0,1").append("\n").append("2,1").append("\n").append("0,2");
		System.setIn(new ByteArrayInputStream(userInputBuilder.toString().getBytes()));

		assertEquals(GAME_WINNER_PLAYERX_MESSAGE, gameExecutor.runGame());
	}

}