package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.INDEX_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.INDEX_ZERO;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.INVALID_POSITION_MINUS_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.INVALID_POSITION_THREE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_O;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_X;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_TWO;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnppf.tdd.tictactoe.model.Position;

@SpringBootTest
public class GameBoardTest {

	@Autowired
	private GameBoard gameBoard;

	@Test
	@DisplayName("Board to accept a move at a poistion from Player X")
	public void playerXShouldBeAbleToMakeMoveInAnyPositionOnTheBoardAndIdentifyTheSame() {
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position);

		assertEquals(PLAYER_X, gameBoard.identifyPlayerAt(position));
	}

	@Test
	@DisplayName("Should get next player based upon current player")
	public void shouldGetNextPlayerBasedUponCurrentPlayer() {
		assertEquals(PLAYER_X, gameBoard.getNextPlayer());
		
		Position position = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position);
		
		assertEquals(PLAYER_O, gameBoard.getNextPlayer());
		
	}
	
	@Test
	@DisplayName("Players should be switched alternatively while placing moves on the board")
	public void playersShouldBeSwitchedAlternativelyWhilePlaying() {
		Position position1 = new Position(POSITION_ONE, POSITION_ONE);
		gameBoard.placeMoveOnTheBoard(position1);
		
		assertEquals(PLAYER_X, gameBoard.identifyPlayerAt(position1));

		Position position2 = new Position(POSITION_ZERO, POSITION_TWO);
		gameBoard.placeMoveOnTheBoard(position2);
		
		assertEquals(PLAYER_O, gameBoard.identifyPlayerAt(position2));
	}
	
	@Test
	@DisplayName("Check if position is out of board range")
	public void shouldReturnTrueWhenPositionIsOutOfRange() {
		Position invalidPosition = new Position(POSITION_ZERO, INVALID_POSITION_THREE);

		assertTrue(gameBoard.isPositionOutOfRange(invalidPosition));
	}
	
	@ParameterizedTest(name="#{index} - Test with Position: ({0},{1})")
	@DisplayName("Additional check for different combinations of out of range positions")
	@MethodSource("invalidPositionsProvider")
	public void addditionalCheckForDifferentOutOfRangePositions(int row, int column) {
		Position invalidPosition = new Position(row, column);

		assertTrue(gameBoard.isPositionOutOfRange(invalidPosition));
	}
	
	@Test
	@DisplayName("Check if input position already occupied")
	public void shouldReturnTrueIfPositionAlreadyOccupied() {
		Position position1 = new Position(POSITION_ZERO, POSITION_TWO);
		gameBoard.placeMoveOnTheBoard(position1);
		Position position2 = new Position(POSITION_ZERO, POSITION_TWO);

		assertTrue(gameBoard.isPositionOccupied(position2));
	}
	
	@Test
	@DisplayName("Check if any row of the board is occupied by same player")
	public void shouldReturnTrueWhenAnyRowOfTheBoardIsOccupiedBySamePlayer() {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ONE, POSITION_ONE },
				{ POSITION_ZERO, POSITION_ONE }, { POSITION_TWO, POSITION_ONE }, { POSITION_ZERO, POSITION_TWO } };
		
		placingMovesOnTheBoard(moves);

		assertTrue(gameBoard.isAnyRowOccupiedBySamePlayer());
	}
	
	@Test
	@DisplayName("Check if any column of the board is occupied by same player")
	public void shouldReturnTrueWhenAnyColumnOfTheBoardIsOccupiedBySamePlayer() {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ONE, POSITION_ONE },
				{ POSITION_ONE, POSITION_ZERO }, { POSITION_TWO, POSITION_ONE }, { POSITION_TWO, POSITION_ZERO } };
		
		placingMovesOnTheBoard(moves);

		assertTrue(gameBoard.isAnyColumnOccupiedBySamePlayer());
	}
	
	@Test
	@DisplayName("Check if top left to bottom right diagonal of the board is occupied by same player")
	public void shouldReturnTrueWhenDiagonalFromTopLeftToBottomRightOfTheBoardIsOccupiedBySamePlayer() {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ZERO, POSITION_ONE },
				{ POSITION_ONE, POSITION_ONE }, { POSITION_TWO, POSITION_ONE }, { POSITION_TWO, POSITION_TWO } };

		placingMovesOnTheBoard(moves);

		assertTrue(gameBoard.isTopLeftToBottomRightDiagonalOccupiedBySamePlayer());
	}
	
	@Test
	@DisplayName("Check if top right to bottom left diagonal of the board is occupied by same player")
	public void shouldReturnTrueWhenDiagonalFromTopRightToBottomLeftOfTheBoardIsOccupiedBySamePlayer() {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_TWO, POSITION_ZERO },
				{ POSITION_ONE, POSITION_ZERO }, { POSITION_ONE, POSITION_ONE }, { POSITION_ONE, POSITION_TWO },
				{ POSITION_ZERO, POSITION_TWO } };

		placingMovesOnTheBoard(moves);

		assertTrue(gameBoard.isTopRightToBottomLeftDiagonalOccupiedBySamePlayer());
	}
	
	@Test
	@DisplayName("Check if all position on board are occupied by players")
	public void shouldReturnTrueWhenAllPositionsOnBoardAreOccupied() {
		int[][] moves = { { POSITION_ZERO, POSITION_ZERO }, { POSITION_ZERO, POSITION_ONE },
				{ POSITION_ZERO, POSITION_TWO }, { POSITION_ONE, POSITION_ONE }, { POSITION_ONE, POSITION_ZERO },
				{ POSITION_ONE, POSITION_TWO }, { POSITION_TWO, POSITION_ONE }, { POSITION_TWO, POSITION_ZERO },
				{ POSITION_TWO, POSITION_TWO } };

		placingMovesOnTheBoard(moves);

		assertTrue(gameBoard.areAllPositionOnBoardOccupied());
	}
	
	private static Stream<Arguments> invalidPositionsProvider() {
		return Stream.of(arguments(INVALID_POSITION_MINUS_ONE, POSITION_ZERO),
				arguments(INVALID_POSITION_THREE, POSITION_ONE), arguments(POSITION_ZERO, INVALID_POSITION_MINUS_ONE));
	}
	
	private void placingMovesOnTheBoard(int[][] moves) {
		Position position;

		for (int i = INDEX_ZERO; i < moves.length; i++) {
			position = new Position(moves[i][INDEX_ZERO], moves[i][INDEX_ONE]);
			gameBoard.placeMoveOnTheBoard(position);
		}
	}

}
