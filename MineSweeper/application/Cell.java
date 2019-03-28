package application;

class Cell {
	private boolean isRevealed;
	private boolean isMine;
	private boolean isFlagged;
	private int nearbyMines;
	private int x,y;
	
	// No Arg Constructor
	public Cell() {
	}
	
	//Constructor
	public Cell(boolean isRevealed, boolean isMine, boolean isFlagged, int nearbyMines) {
		this.isRevealed = isRevealed;
		this.isMine = isMine;
		this.isFlagged = isFlagged;
		this.nearbyMines = nearbyMines;
		this.x = 0;
		this.y = 0;
	}
	
	// Setter method for revealing Cells
	public void revealCell() {
		this.isRevealed = true;
	}
	public Boolean checkRevealed() {
		return this.isRevealed;
	}
	
	// setter method for flagging Cells
	public void flagCell() {
		this.isFlagged = true;
	}
	// setter method to unflag cell
	public void unflagCell() {
		this.isFlagged = false;
	}
	// setter method for nearby Cells
	public void setMineCount(int mines) {
		this.nearbyMines = mines;
	}
	// Getter method for nearby Cells
	public int getMineCount() {
		return this.nearbyMines;
	}
	// Getter method checking if Cell is a mine or not
	public boolean mineCheck() {
		return this.isMine;
	}
	//Getter method for checking if a cell is flagged
	public boolean flagCheck() {
		return this.isFlagged;
	}
	// To String Method containing result of the current cell clicked
	public String toString() {
		String result = "";
		if (this.isMine) {
			result = "*";
		}else if(this.nearbyMines == 0){
			result = " ";;
		} else {
			result = "" + this.nearbyMines;
		}
		return result;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
}