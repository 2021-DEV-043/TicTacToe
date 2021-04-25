package com.bnppf.tdd.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.game.TicTacToeGameExecutor;

@Component
public class TicTacToeApplicationRunner implements ApplicationRunner {

	@Autowired
	private TicTacToeGameExecutor gameExecutor;

	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeApplicationRunner.class);

	@Override
	public void run(ApplicationArguments args) {
		String result = gameExecutor.runGame();
		LOGGER.info(result);
	}
}
