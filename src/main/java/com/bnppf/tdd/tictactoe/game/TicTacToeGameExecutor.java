package com.bnppf.tdd.tictactoe.game;

import org.springframework.stereotype.Component;

@Component
public class TicTacToeGameExecutor {

	public boolean isUserInputInvalid(String[] userInputs) {
		return userInputs.length != 2;
	}

}