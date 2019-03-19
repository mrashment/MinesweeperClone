package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

public class MineSweeperController {
	@FXML
	private Label scoreLbl;
	@FXML
	private Button restartBtn;
	@FXML
	private Button startBtn;

	
	@FXML
	private void btnPressed(ActionEvent event) {
		Button pressedButton = (Button) event.getSource();
		pressedButton.setVisible(false);
	}
}
