package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.USER_INPUT_SIZE;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGameExecutor {

	public boolean isUserInputInvalid(String[] userInputs) {
		boolean isInvalid = true;

		if (userInputs.length == USER_INPUT_SIZE && userInputs[INDEX_ZERO].matches("\\d+") 
				&& userInputs[INDEX_ONE].matches("\\d+")) {
			isInvalid = false;
		}

		return isInvalid;
	}

}