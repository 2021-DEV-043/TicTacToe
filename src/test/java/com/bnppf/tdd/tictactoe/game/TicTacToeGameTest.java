package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.GAME_CONTINUE_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.GAME_WINNER_PLAYERX_MESSAGE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.INDEX_ZERO;
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

import com.bnppf.tdd.tictactoe.exception.PositionAlreadyOccupiedException;
import com.bnppf.tdd.tictactoe.exception.PositionOutOfRangeException;
import com.bnppf.tdd.tictactoe.model.Position;

@SpringBootTest
public class TicTacToeGameTest {

	@Autowired
	private TicTacToeGame game;
	
	@Test
	@DisplayName("Game should allow player X to play at any position on the board")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position);

		assertEquals(PLAYER_X, game.identifyPlayerAt(position));
	}
	
	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		assertEquals(PLAYER_X, game.getNextPlayer());
		
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position);
		
		assertEquals(PLAYER_O, game.getNextPlayer());
		
	}
	
	@Test
	@DisplayName("Game should switch players alternatively while playing")
	public void playersShouldBeSwitchedAlternativelyWhilePlaying() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
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
	
	@Test
	@DisplayName("Game should throw exception if position is already occupied")
	public void shouldThrowExceptionIfPositionIsAlreadyOccupied() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		Position position1 = new Position(POSITION_ONE, POSITION_ONE);
		game.play(position1);

		Position position2 = new Position(POSITION_ONE, POSITION_ONE);

		assertThrows(PositionAlreadyOccupiedException.class, () -> game.play(position2));
	}
	
	@Test
	@DisplayName("Game should return continue if any position available")
	public void shouldReturnContinueIfAnyPositionAvailableForPlayer() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		Position position = new Position(POSITION_ONE, POSITION_ONE);

		assertEquals(GAME_CONTINUE_MESSAGE, game.play(position));	
	}
	
	@Test
	@DisplayName("Game should declare player as winner if any row occupied by that player")
	public void declareThePlayerAsWinnerIfThePlayerCompletelyOccupiesAnyRow() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ONE, POSITION_ONE },
				{ POSITION_ZERO, POSITION_ONE }, { POSITION_TWO, POSITION_ONE } };
		
		playEarlierMoves(moves);

		Position position5 = new Position(POSITION_ZERO, POSITION_TWO);

		assertEquals(GAME_WINNER_PLAYERX_MESSAGE, game.play(position5));
	}
	
	@Test
	@DisplayName("Game should declare player as winner if any column occupied by that player")
	public void declareThePlayerAsWinnerIfThePlayerCompletelyOccupiesAnyColumn() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ONE, POSITION_ONE },
				{ POSITION_ONE, POSITION_ZERO }, { POSITION_TWO, POSITION_ONE } };
		
		playEarlierMoves(moves);

		Position position5 = new Position(POSITION_TWO, POSITION_ZERO);

		assertEquals(GAME_WINNER_PLAYERX_MESSAGE, game.play(position5));
	}
	
	@Test
	@DisplayName("Game should declare player as winner if top left to bottom right diagonal is occupied by that player")
	public void declareThePlayerAsWinnerIfThePlayerCompletelyOccupiesTopLeftToBottonRightDiagonal() throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ZERO, POSITION_ONE },
				{ POSITION_ONE, POSITION_ONE }, { POSITION_TWO, POSITION_ONE } };

		playEarlierMoves(moves);

		Position position = new Position(POSITION_TWO, POSITION_TWO);

		assertEquals(GAME_WINNER_PLAYERX_MESSAGE, game.play(position));
	}
	
	private void playEarlierMoves(int[][] moves) throws PositionOutOfRangeException, PositionAlreadyOccupiedException {
		Position position;

		for (int i = INDEX_ZERO; i < moves.length; i++) {
			position = new Position(moves[i][INDEX_ZERO], moves[i][INDEX_ONE]);
			game.play(position);
		}
	}

}