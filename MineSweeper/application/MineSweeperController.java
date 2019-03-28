package application;

import java.io.IOException;

import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MineSweeperController {
	@FXML
	private Label scoreLbl;
	@FXML
	private Button restartBtn;
	@FXML
	private Button startBtn;

	@FXML
	private GridPane boardPane;
	
    @FXML
    private CheckBox flagCheckBox;
    
    @FXML
    private Button surrenderBtn;
    
    @FXML
    private Label resultLabel;

	private Board game;


	@FXML
	private void btnPressed(ActionEvent event) {
		Button pressedButton = (Button) event.getSource();
		//pressedButton.setVisible(false);
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
		if(flagCheckBox.isSelected()) {
			if(pressedButton.getText().equals("F")) {
				pressedButton.setText("");
				game.getCell(pressedButtonCol, pressedButtonRow).unflagCell();
			} else {
				pressedButton.setText("F");
				game.getCell(pressedButtonCol, pressedButtonRow).flagCell();
			}
		} else if(pressedButton.getText().equals("F")){
			
		} else {
			//game.getCellArray()[pressedButtonRow][pressedButtonCol].revealCell();
			game.revealCell(game.getCell(pressedButtonCol, pressedButtonRow), pressedButtonCol, pressedButtonRow);
			System.out.println(game.getCell(pressedButtonCol, pressedButtonRow).toString());
			this.checkReveal();
			//game.checkStatus(pressedButtonRow, pressedButtonCol);
			//System.out.println(pressedButtonRow + ", " + pressedButtonCol + " revealed");
			if(game.checkWin()) {
				resultLabel.setText("You win!");
				resultLabel.setTextFill(Color.GREEN);
				resultLabel.setVisible(true);
				this.flagCheckBox.setSelected(true);
				this.flagCheckBox.setVisible(false);
				//this.clearBoard();
			} else if(game.checkLoss()) {
				resultLabel.setText("You lose!");
				resultLabel.setTextFill(Color.RED);
				resultLabel.setVisible(true);
				this.clearBoard();
			}
		}

	}

	@FXML
	private void startPressed(ActionEvent event) {
		this.boardPane.setVisible(true);
		this.restartBtn.setVisible(true);
		this.startBtn.setVisible(false);
		this.flagCheckBox.setVisible(true);
		this.surrenderBtn.setVisible(true);
		this.game = new Board(10,10);
		this.buildBoard();

	}

	private void buildBoard() {
		for(int i = 0; i < game.getCellArray().length; i++) {
			for(int j = 0; j < game.getCellArray()[i].length; j++) {
				Cell thisCell = game.getCell(i, j);
				Label cellLabel = new Label();
				cellLabel.setText(thisCell.toString());
				cellLabel.setFont(Font.getDefault());
				cellLabel.setPrefSize(81, 31);
				cellLabel.setTextAlignment(TextAlignment.CENTER);
				boardPane.add(cellLabel, i, j);
				switch(thisCell.toString()) {
				case "*":
					cellLabel.setTextFill(Color.RED);
					break;
				case "1":
					cellLabel.setTextFill(Color.DARKBLUE);
					break;
				case "2":
					cellLabel.setTextFill(Color.DARKGREEN);
					break;
				case "3":
					cellLabel.setTextFill(Color.DARKRED);
					break;
				case "4":
					cellLabel.setTextFill(Color.BLUEVIOLET);
					break;
				case "5":
					cellLabel.setTextFill(Color.DARKGOLDENROD);
					break;
				default:
					cellLabel.setTextFill(Color.BROWN);
					break;
				}
				cellLabel.setStyle("-fx-font-weight: bold");
				GridPane.setFillWidth(cellLabel, true);
				cellLabel.setMaxWidth(Double.MAX_VALUE);
				cellLabel.setAlignment(Pos.CENTER);
				cellLabel.toBack();
			}
		}
	}
	
	@FXML
	private void clearBtn(ActionEvent event) {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}
	
	
	@FXML
	private void restart(ActionEvent event) {
		Stage primaryStage = (Stage) this.scoreLbl.getScene().getWindow();
		primaryStage.close();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane mineLayout;
		
		try {
			loader.setLocation(Main.class.getResource("/MineSweeper.fxml"));
			mineLayout = (AnchorPane) loader.load();
			Scene scene = new Scene (mineLayout);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		primaryStage.show();
	}
	
	void checkReveal() {
		for(int i = 0; i < game.getCellArray().length; i++) {
			for(int j = 0; j < game.getCellArray()[i].length; j++) {
				if(game.getCell(i, j).checkRevealed()) {
					for(Node a: boardPane.getChildren()) {
						int nodeRow = 0;
						int nodeCol =  0;
						//System.out.println(GridPane.getRowIndex(pressedButton) + ", " + GridPane.getColumnIndex(pressedButton));
						if(GridPane.getRowIndex(a) == null) {
							nodeRow = 0;
						} else {
							nodeRow = GridPane.getRowIndex(a);
						}
						if(GridPane.getColumnIndex(a) == null) {
							nodeCol = 0;
						} else {
							nodeCol = GridPane.getColumnIndex(a);
						}
						if(a != null && a instanceof Button && nodeCol == i && nodeRow == j) {
							a.setVisible(false);
						}
					}
				}
			}
		}
	}
	
	void clearBoard() {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}

}
