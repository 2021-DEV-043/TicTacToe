package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.USER_INPUT_SIZE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.VALID_PATTERN;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.exception.InvalidUserInputException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGameExecutor {

	
	public void validateUserInputs(String[] userInputs) throws InvalidUserInputException {
		if (isUserInputInvalid(userInputs)) {
			throw new InvalidUserInputException(INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE);
		}
	}
	
	public boolean isUserInputInvalid(String[] userInputs) {
		boolean isInvalid = true;

		if (userInputs.length == USER_INPUT_SIZE && userInputs[INDEX_ZERO].matches(VALID_PATTERN) 
				&& userInputs[INDEX_ONE].matches(VALID_PATTERN)) {
			isInvalid = false;
		}

		return isInvalid;
	}

}