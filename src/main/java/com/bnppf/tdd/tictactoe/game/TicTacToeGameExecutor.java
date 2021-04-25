package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_CONTINUE_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_ERROR_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAME_STARTED_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_EIGHT;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_FIVE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_FOUR;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_SEVEN;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_SIX;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_THREE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.GAMING_INSTRUCTION_TWO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.NEXT_PLAYER_INFORMATION;
import static com.bnppf.tdd.tictactoe.constant.GameConstants.USER_INPUT_SEPARATOR;
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
		String result = GAME_STARTED_MESSAGE;
		Scanner scan = new Scanner(System.in);
		
		String instruction = displayGamingInstructions();
		LOGGER.info(instruction);

		while (isGameToBeContinued(result)) {
			try {
				String playerToContinue = String.format(NEXT_PLAYER_INFORMATION, game.getNextPlayer());
				LOGGER.info(playerToContinue);
				
				String[] input = scan.nextLine().split(USER_INPUT_SEPARATOR);
				validateUserInputs(input);
				result = game.play(new Position(Integer.parseInt(input[INDEX_ZERO]), Integer.parseInt(input[INDEX_ONE])));
				
				game.printGameBoard();
			} catch (InvalidUserInputException | PositionOutOfRangeException | PositionAlreadyOccupiedException exception) {
				String errorMessage = String.format("%s %s", GAME_ERROR_MESSAGE, exception.getMessage());
				LOGGER.error(errorMessage);
			}
		}
		scan.close();

		return result;
	}
	
	private String displayGamingInstructions() {
		StringBuilder builder = new StringBuilder();
		builder.append(GAMING_INSTRUCTION_ONE);
		builder.append(GAMING_INSTRUCTION_TWO);
		builder.append(GAMING_INSTRUCTION_THREE);
		builder.append(GAMING_INSTRUCTION_FOUR);
		builder.append(GAMING_INSTRUCTION_FIVE);
		builder.append(GAMING_INSTRUCTION_SIX);
		builder.append(GAMING_INSTRUCTION_SEVEN);
		builder.append(GAMING_INSTRUCTION_EIGHT);
		return builder.toString();
	}

	private boolean isGameToBeContinued(String result) {
		return GAME_CONTINUE_MESSAGE.equals(result) || GAME_STARTED_MESSAGE.equals(result);
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