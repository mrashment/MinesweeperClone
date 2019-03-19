package application;

public class Board {
	
	private Cell[][] cellArray;
	private int mines;
	
	private Board(int width, int height) {
		mines = 0;
		cellArray = new Cell[width][height];
		
		for(int i = 0; i < cellArray.length; i++) {
			for(int j = 0; j < cellArray[0].length; j++) {
				cellArray[i][j] = this.getRandomCell();
			}
		}
	}
	
	private Cell getRandomCell() {
		Cell returnCell;
		Boolean isRevealed = false;
		Boolean isMine = false;
		while(mines < 11) {
			int mineRandom = (int) Math.random() * 10;
			if(mineRandom > 5) {
				isMine = true;
			} else {
				isMine = false;
			}
			returnCell = new Cell(false, isMine, false, 0);
			this.mines++;
			return returnCell;
		}
		returnCell = new Cell(false, false, false, 0);
		return returnCell;
	}

}
