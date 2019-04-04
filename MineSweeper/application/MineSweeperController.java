package application;

import java.io.IOException;

import javax.print.DocFlavor.URL;

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
import javafx.scene.image.ImageView;
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
		//gets an instance of the button that was pressed
		Button pressedButton = (Button) event.getSource();
		//pressedButton.setVisible(false);
		
		
		int pressedButtonRow = 0;
		int pressedButtonCol =  0;
		//System.out.println(GridPane.getRowIndex(pressedButton) + ", " + GridPane.getColumnIndex(pressedButton));
		
		//this grabs the coordinates of what button was pressed so it knows what cell to reveal
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
		
		//this determines the action when the button is clicked. Flag or not.
		if(flagCheckBox.isSelected()) {
			if(pressedButton.getGraphic() != null) {
				pressedButton.setGraphic(null);
				game.getCell(pressedButtonCol, pressedButtonRow).unflagCell();
			} else {
				ImageView flagImg = new ImageView("/flag.png");
				flagImg.setFitWidth(31);
				flagImg.setFitHeight(31);
				pressedButton.setGraphic(flagImg);
				game.getCell(pressedButtonCol, pressedButtonRow).flagCell();
			}
		} else if(pressedButton.getGraphic() != null){
			
		} else {
			//Runs the code when flag is not selected. Reveals the cell and recursively reveal adjacent empty cells.
			
			//game.getCellArray()[pressedButtonRow][pressedButtonCol].revealCell();
			game.revealCell(game.getCell(pressedButtonCol, pressedButtonRow), pressedButtonCol, pressedButtonRow);
			
			System.out.println(game.getCell(pressedButtonCol, pressedButtonRow).toString() + " bombs near revealed cell.");
			
			this.checkReveal();
			//game.checkStatus(pressedButtonRow, pressedButtonCol);
			//System.out.println(pressedButtonRow + ", " + pressedButtonCol + " revealed");
			if(game.checkWin()) {
				resultLabel.setText("You win!");
				resultLabel.setTextFill(Color.GREEN);
				resultLabel.setVisible(true);
				this.flagCheckBox.setSelected(true);
				this.flagCheckBox.setVisible(false);
				this.clearBoard();
			} else if(game.checkLoss()) {
				resultLabel.setText("You lose!");
				resultLabel.setTextFill(Color.RED);
				resultLabel.setVisible(true);
				this.clearBoard();
			}
		}

	}

	
	//instantiates local variables and sets up the board to be played
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

	
	//fills the board and sets the colors for numbers and images for bombs
	private void buildBoard() {
		for(int i = 0; i < game.getCellArray().length; i++) {
			for(int j = 0; j < game.getCellArray()[i].length; j++) {
				Cell thisCell = game.getCell(i, j);
				Label cellLabel = new Label();

				if(!thisCell.mineCheck()) {
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
				} else {
					ImageView bombImg = new ImageView("/bomb.png");
					bombImg.setFitHeight(31);
					bombImg.setFitWidth(31);
					cellLabel.setGraphic(bombImg);
					boardPane.add(cellLabel, i, j);
					GridPane.setFillWidth(cellLabel, true);
					cellLabel.setMaxWidth(Double.MAX_VALUE);
					cellLabel.setAlignment(Pos.CENTER);
					cellLabel.toBack();
				}
			}
		}
	}
	
	
	//Reveals all cells on board
	@FXML
	private void clearBtn(ActionEvent event) {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}
	
	//restarts the game.
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
	
	
	//Call this function to reveal buttons that are covering revealed cells.
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
	
	
	//function to clear the board without a button press
	void clearBoard() {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}

}
