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
	
	// setter method for flagging Cells
	public void flagCell() {
		this.isFlagged = true;
	}
	// setter method to unflag cell
	public void unflagCell() {
		this.isFlagged = false;
	}
	// Getter method for nearby Cells
	public int countNearbyMines() {
		int nearMines = this.nearbyMines;
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
		if (this.mineCheck()) {
			result += "*";
		}
		if (this.isFlagged) {
			result += "F";
		}
		return result;
	}
}