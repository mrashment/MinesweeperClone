package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class BoardTest {

	Board testBoard;
	Cell [][] cellArray;
	int mines;
	int x;
	int y;
	Cell [][] a;
	


	@Before
	public void setUp() throws Exception{
		Random r = new Random();
		int x = r.nextInt(1);
		int y = r.nextInt(2);
		
		Board testBoard = new Board(10,10,10);
		Cell[][] cellArray = new Cell [x][y];
		Cell[][] a = new Cell [1][1];
	}

	@Test
	void testBoard() {
		assertNull(testBoard);
	}

	@Test
	void testGetCellArray() {
		assertNull(cellArray);
	}


	@Test
	void testGetCell() {
		int x = 1;
		int y = 1;
		Cell[][] cell = new Cell[1][1];
		Cell[][] cellTest = new Cell[x][y];
		assertArrayEquals(cell, cellTest);
	}

	@Test
	void testShuffle() {
		assertNull(a);
	}

	@Test
	void testGetSurroundingMines() {
		int mineCount = 0;
		
		assertNotNull(mineCount);
	}

	@Test
	void testRevealCell() {
		assertNull(cellArray);		
	}


	@Test
	void testCheckStatus() {
		assertNull(cellArray);
	}

	@Test
	void testCheckWin() { 
		boolean result = true;
		assertTrue(result);
	}

	@Test
	void testCheckLoss() {
		boolean result = false;
		assertFalse(result);
	}
}


