package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.USER_INPUT_SIZE;

import org.springframework.stereotype.Component;

@Component
public class TicTacToeGameExecutor {

	public boolean isUserInputInvalid(String[] userInputs) {
		return userInputs.length != USER_INPUT_SIZE;
	}

}