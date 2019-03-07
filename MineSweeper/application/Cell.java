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
	
	public void revealCell() {
		this.isRevealed = true;
	}
	
	public void flagCell() {
		this.isFlagged = true;
	}
}