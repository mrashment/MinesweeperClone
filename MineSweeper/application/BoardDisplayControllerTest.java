package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardDisplayControllerTest {
	Board mineSweeper;

	
	@Test
	void testReveal() {
		Cell test1 = new Cell(true,false,false,3);
		assertTrue(test1.checkRevealed());
	}
	
	
	@Test
	void testClearBoard() {
			assertNull(mineSweeper);
		}
	
	

}