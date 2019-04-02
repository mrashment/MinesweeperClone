# MineSweeper By Team1

## Team Members

|Member|Role|
|------|----|
|Christian Coplen|Documentation & Cell Class|
|Austin Walker|Tester & GUI|
|Ashton Smith|Architect & Board|

## Classes

### Cell

The cell class is used to create new cells which are then stored in the board's ArrayList to be used in the game. This class includes methods for checking if a cell is a mine, is flagged, or has been revealed which then determines how it is represented in the board and a method to show the count of nearby mines, as well as other methods used to set the status of the cell used in the board.

### Board

The board class is used to create a list to store Cells in and plays a large part in the making of our game. This class includes some complex methods for generating the board itself and storing cells inside of it and randomizing the placement of the mines as well as methods for revealing the spaces on the board recursively if a blank cell has been clicked. This class also contains the methods to check if a game has been won or lost.

### GUI

## Bugs and Unresolved Issues

At this point in time, there are no known bugs in our game. If one is found we will move swiftly to get rid of it!

## UML Diagram
![alt text](https://raw.githubusercontent.com/cmcoplen/MineSweeper_Team1/master/Images/MineSweeperUML.png)
