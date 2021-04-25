package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_CONTINUE_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.USER_INPUT_SIZE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.VALID_PATTERN;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnppf.tdd.tictactoe.exception.InvalidUserInputException;
import com.bnppf.tdd.tictactoe.exception.PositionAlreadyOccupiedException;
import com.bnppf.tdd.tictactoe.exception.PositionOutOfRangeException;
import com.bnppf.tdd.tictactoe.model.Position;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TicTacToeGameExecutor {

	@Autowired
	private TicTacToeGame game;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeGameExecutor.class);
	
	public String runGame() {
		String result = "Game Started";
		Scanner scan = new Scanner(System.in);

		while (GAME_CONTINUE_MESSAGE.equals(result) || "Game Started".equals(result)) {
			try {
				String[] input = scan.nextLine().split(",");
				validateUserInputs(input);
				result = game.play(new Position(Integer.parseInt(input[INDEX_ZERO]), Integer.parseInt(input[INDEX_ONE])));
			} catch (InvalidUserInputException | PositionOutOfRangeException | PositionAlreadyOccupiedException exception) {
				String errorMessage = String.format("%s %s", "Error while playing game...!!", exception.getMessage());
				LOGGER.error(errorMessage);
			}
		}
		scan.close();

		return result;
	}
	
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