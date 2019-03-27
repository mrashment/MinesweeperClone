package application;

import java.util.ArrayList;
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
		getSurroundingMines(this.cellArray);
		for(int i = 0; i < cellArray.length; i++) {
			for(int j = 0; j < cellArray[i].length; j++) {
				this.cellArray[i][j].setCoords(i, j);;
			}
		}
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

	void getSurroundingMines(Cell[][] a) {
		int mineCount = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				Cell thisCell = a[i][j];
				mineCount = 0;
				for(int m = 0; m < a.length; m++) {
					for(int n = 0; n < a[m].length; n++) {
						int distanceBetweenCells = (int) Math.abs(Math.sqrt((n - j) * (n - j) + (m - i) * (m - i)));
						if(distanceBetweenCells == 1 && a[m][n].mineCheck()) {
							mineCount++;
						}
					}
				}
				thisCell.setMineCount(mineCount);
			}
		}
	}
	private void revealSurrounding(Cell a, int x, int y) {
		ArrayList<Cell> adjacentList = new ArrayList<>();
		for(int i = 0; i < this.cellArray.length; i++) {
			for(int j = 0; j < this.cellArray[i].length; j++) {
				if((int) Math.abs(Math.sqrt((j - y) * (j - y) + (i - x) * (i - x))) == 1) {
					//int distanceBetweenCells = (int) Math.abs(Math.sqrt((j - y) * (j - y) + (i - x) * (i - x)));
					System.out.println("distance between (" + x + ", " + y + ") and (" + i + ", " + j + ") is " + (int) Math.abs(Math.sqrt((j - y) * (j - y) + (i - x) * (i - x))));
					if(!this.cellArray[i][j].toString().equals("*") && !this.cellArray[i][j].checkRevealed() && !this.cellArray[i][j].mineCheck()) {
						adjacentList.add(cellArray[i][j]);
					}
				}
			}
		}
		for(int i = 0; i < adjacentList.size(); i++) {
			this.revealCell(adjacentList.get(i), adjacentList.get(i).getX(), adjacentList.get(i).getY());
		}
	}
	public void revealCell(Cell a, int x, int y) {
		a.revealCell();
		System.out.println(x + ", " + y + " revealed");
		if(a.getMineCount() == 0) {
			this.revealSurrounding(a, x, y);
		}
	}

	public void checkStatus(int row, int col) {
		if(cellArray[col][row].mineCheck()) {
			System.out.println("You lose.");
		}
	}

}
