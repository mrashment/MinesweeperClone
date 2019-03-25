package application;

import java.util.Random;

public class Board {

	private Cell[][] cellArray;
	private int mines;

	public Board(int width, int height) {
		this.mines = 0;
		this.cellArray = new Cell[width][height];

		for(int i = 0; i < cellArray.length; i++) {
			for(int j = 0; j < cellArray[i].length; j++) {
				this.cellArray[i][j] = this.getRandomCell();
			}
		}
		shuffle(this.cellArray);
	}

	public Cell[][] getCellArray() {
		return cellArray;
	}

	//public void setCellArray(Cell[][] cellArray) {
	//	this.cellArray = cellArray;
	//}

	private Cell getRandomCell() {
		Cell returnCell;
		//Boolean isRevealed = false;
		while(mines < 10) {
			returnCell = new Cell(false, true, false, 0);
			this.mines++;
			return returnCell;
		}
		returnCell = new Cell(false, false, false, 0);
		return returnCell;
	}
	
	public Cell getCell(int row, int column) {
		return cellArray[row][column];
	}


	//Shuffle the array so the bombs are placed in random locations
	void shuffle(Cell[][] a) {
		Random random = new Random();

		for (int i = a.length - 1; i > 0; i--) {
			for (int j = a[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);

				Cell temp = a[i][j];
				a[i][j] = a[m][n];
				a[m][n] = temp;
			}
		}
	}

	public void checkStatus(int row, int col) {
		if(cellArray[col][row].mineCheck()) {
			System.out.println("You lose.");
		}
	}

}
