package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell = new Cell();
	
	@Test
	void testCell() {
		assertNotNull(cell);
	}

	@Test
	void testCellBooleanBooleanBooleanInt() {
		Cell testCell = new Cell(true,true,false,1);
		Cell test2Cell = new Cell(true,true,false,1);
		assertEquals(testCell,test2Cell);
	}

	@Test
	void testCheckRevealed() {
		Cell testCell = new Cell(true,true,false,1);
		assertTrue(testCell.checkRevealed());
	}

	@Test
	void testSetMineCount() {
		Cell testCell = new Cell(false,true,false,2);
		Cell test2Cell = new Cell(false,true,false,1);
		assertNotEquals(testCell,test2Cell);
	}

	@Test
	void testGetMineCount() {
		Cell testCell = new Cell(true,true,false,1);
		assertEquals(1, testCell.getMineCount());
	}

	@Test
	void testToString() {
		Cell testCell = new Cell(false,true,false,2);
		assertNotNull(testCell.toString());
		
	}

	@Test
	void testGetX() {
		Cell testCell = new Cell(false,true,false,2);
		testCell.setCoords(0, 0);
		assertEquals(0,testCell.getX());
	}

	@Test
	void testGetY() {
		Cell testCell = new Cell(false,true,false,2);
		testCell.setCoords(0, 0);
		assertEquals(0,testCell.getY());
	}

	@Test
	void testSetCoords() {
		Cell testCell = new Cell(false,true,false,2);
		testCell.setCoords(0, 0);
		assertEquals(0,testCell.getX());
	}

}
