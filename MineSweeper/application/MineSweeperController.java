package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MineSweeperController {
	@FXML
	private Label scoreLbl;
	@FXML
	private Button restartBtn;
	@FXML
	private Button startBtn;

	@FXML
	private GridPane boardPane;

	private Board game;


	@FXML
	private void btnPressed(ActionEvent event) {
		Button pressedButton = (Button) event.getSource();
		pressedButton.setVisible(false);
		int pressedButtonRow = 0;
		int pressedButtonCol =  0;
		//System.out.println(GridPane.getRowIndex(pressedButton) + ", " + GridPane.getColumnIndex(pressedButton));
		if(GridPane.getRowIndex(pressedButton) == null) {
			pressedButtonRow = 0;
		} else {
			pressedButtonRow = GridPane.getRowIndex(pressedButton);
		}
		if(GridPane.getColumnIndex(pressedButton) == null) {
			pressedButtonCol = 0;
		} else {
			pressedButtonCol = GridPane.getColumnIndex(pressedButton);
		}
		game.getCellArray()[pressedButtonRow][pressedButtonCol].revealCell();
		game.checkStatus(pressedButtonRow, pressedButtonCol);
		System.out.println(pressedButtonRow + ", " + pressedButtonCol);

	}

	@FXML
	private void startPressed(ActionEvent event) {
		this.boardPane.setVisible(true);
		this.game = new Board(6,6);
		this.buildBoard();

	}

	private void buildBoard() {
		for(int i = 0; i < game.getCellArray().length; i++) {
			for(int j = 0; j < game.getCellArray()[i].length; j++) {
				Cell thisCell = game.getCell(i, j);
				Label cellLabel = new Label();
				cellLabel.setText(thisCell.toString());
				cellLabel.setFont(Font.getDefault());
				cellLabel.setTextAlignment(TextAlignment.CENTER);
				cellLabel.autosize();
				boardPane.add(cellLabel, i, j);
				cellLabel.toBack();
			}
		}
	}


}
