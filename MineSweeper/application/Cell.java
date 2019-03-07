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
	
	// Getter method for nearby Cells
	public int countNearbyMines(Cell currentCell) {
		int nearMines = currentCell.nearbyMines;
		return nearMines;
	}
	// Getter method checking if Cell is a mine or not
	public boolean mineCheck(Cell currentCell) {
		boolean status = currentCell.isMine;
		return status;
	}
}