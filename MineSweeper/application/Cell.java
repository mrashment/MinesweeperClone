package application;

class Cell {
	private boolean isRevealed;
	private boolean isMine;
	private boolean isFlagged;
	
	// No Arg Constructor
	public Cell() {
	}
	
	public Cell(boolean isRevealed, boolean isMine, boolean isFlagged) {
		this.isRevealed = isRevealed;
		this.isMine = isMine;
		this.isFlagged = isFlagged;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		System.out.println("Test");
	}

}
