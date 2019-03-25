package application;

class Cell {
	private boolean isRevealed;
	private boolean isMine;
	private boolean isFlagged;
	private int nearbyMines;
	
	// No Arg Constructor
	public Cell() {
	}
	
	//Constructor
	public Cell(boolean isRevealed, boolean isMine, boolean isFlagged, int nearbyMines) {
		this.isRevealed = isRevealed;
		this.isMine = isMine;
		this.isFlagged = isFlagged;
		this.nearbyMines = nearbyMines;
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
	public int countNearbyMines() {
		int nearMines = nearbyMines;
		return nearMines;
	}
	// Getter method checking if Cell is a mine or not
	public boolean mineCheck() {
		boolean status = this.isMine;
		return status;
	}
	//Getter method for checking if a cell is flagged
	public boolean flagCheck() {
		boolean flagStatus = this.isFlagged;
		return flagStatus;
	}
	// To String Method containing result of the current cell clicked
	public String toString() {
		String result = "";
		if (this.isMine) {
			result = "*";
		}else {
			result = "c";
		}
		return result;
	}
}