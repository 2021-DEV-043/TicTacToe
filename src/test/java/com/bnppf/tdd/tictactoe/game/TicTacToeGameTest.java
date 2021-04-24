package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.INVALID_POSITION_THREE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_O;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_X;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_TWO;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnppf.tdd.tictactoe.exception.PositionOutOfRangeException;
import com.bnppf.tdd.tictactoe.model.Position;

@SpringBootTest
public class TicTacToeGameTest {

	@Autowired
	private TicTacToeGame game;
	
	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() throws PositionOutOfRangeException {
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position);

		assertEquals(PLAYER_X, game.identifyPlayerAt(position));
	}
	
	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() throws PositionOutOfRangeException {
		assertEquals(PLAYER_X, game.getNextPlayer());
		
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position);
		
		assertEquals(PLAYER_O, game.getNextPlayer());
		
	}
	
	@Test
	@DisplayName("Game should switch players alternatively while playing")
	public void playersShouldBeSwitchedAlternativelyWhilePlaying() throws PositionOutOfRangeException {
		Position position1 = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position1);
		
		assertEquals(PLAYER_X, game.identifyPlayerAt(position1));

		Position position2 = new Position(POSITION_ZERO, POSITION_TWO);
		game.play(position2);
		
		assertEquals(PLAYER_O, game.identifyPlayerAt(position2));
	}
	
	@Test
	@DisplayName("Game should throw exception if position is out of valid range")
	public void shouldThrowExceptionIfPositionIsOutOfRangeOfGameBoard() {
		Position position = new Position(POSITION_ONE, INVALID_POSITION_THREE);

		assertThrows(PositionOutOfRangeException.class, () -> game.play(position));
	}

}