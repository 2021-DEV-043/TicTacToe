package com.bnppf.tdd.tictactoe.game;

import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_O;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.PLAYER_X;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ONE;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_TWO;
import static com.bnppf.tdd.tictactoe.constant.TestConstants.POSITION_ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

}
