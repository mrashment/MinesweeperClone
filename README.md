# MineSweeper By Team1

## Team Members

|Member|Role|
|------|----|
|Christian Coplen|Documentation & Cell Class|
|Austin Walker|Tester & GUI|
|Ashton Smith|Architect & Board|

## Introduction
This is a basic 10x10 MineSweeper game that everyone knows and loves developed in Java and JavaFX. 

# Classes

## Cell Class
The Cell class stores information about a Cell such as if a Cell has been revealed, if a Cell contains a mine, if a Cell has been Flagged by the user, the amount of mines adjacent to a cell, and the x and y positions of a Cell in the grid.

### Methods
**revealCell** a void method that sets the status of a cell to revealed.

**checkRevealed** a method that returns a boolean, true if the cell is revealed and false if the cell has not been revealed.

**flagCell** a void method that sets the flag status of a cell to true.

**unflagCell** a void method that sets the flag status of a cell to false.

**setMineCount** a method intended for use within the board, stores the amount of mines near a Cell.

**getMineCount** a method that returns the count of nearby mines of a Cell.

**mineCheck** a method that returns true if a Cell is a mine, or false if it is not.

**flagCheck** a method that returns true if a Cell is flagged by the user, or false if it is not.

**toString** a method intended for use in the board class, sets the text of the grid containing the cell to reflect if the cell is a mine and if not, display the number of nearby mines to that Cell.

**getX** a method to return the X position of the Cell in the grid.

**getY** a method to return the Y position of the Cell in the grid.

**setCoords** a method that takes in 2 integers, and sets the x and y values of the current cell to those integers in the given order.
