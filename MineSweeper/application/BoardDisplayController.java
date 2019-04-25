package application;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class BoardDisplayController {
	@FXML
	private AnchorPane rightPane;
	@FXML
	private Button surrenderBtn;
	@FXML
	private Button startBtn;
	@FXML
	private Button historyBtn;
	@FXML
	private TextField sizeXField;
	@FXML
	private TextField sizeYField;
	@FXML
	private RadioButton easyRadio;
	@FXML
	private RadioButton mediumRadio;
	@FXML
	private RadioButton hardRadio;
	@FXML
	private ToggleGroup difToggle;
	@FXML
	private CheckBox flagCheckBox;
	@FXML
	private GridPane boardPane;
	@FXML
	private Label resultLabel;
	@FXML
	private Button clearBtn;
	@FXML
	private TextField timeField;
	
	private long startTime;
	Timer timer;
	
	private Board game;
	private int mineTotal;
	private EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			btnPressed(e);
		}
	};
	
	
	public void initialize() {
		easyRadio.setSelected(true);
		sizeXField.setText("5");
		sizeYField.setText("5");
		
	}

	// Event Listener on Button[#startBtn].onAction
	@FXML
	public void startPressed(ActionEvent event) {
		
		
		
		//get user input for size and difficulty
		int sizeX = 1;
		int sizeY = 1;
		int total = 1;
		try {
			sizeX = Integer.parseInt(sizeXField.getText());
			sizeY = Integer.parseInt(sizeYField.getText());
			total = sizeX*sizeY;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (easyRadio.isSelected()) {
			mineTotal = (int)(0.1*total);
		}
		else if (mediumRadio.isSelected()) {
			mineTotal = (int)(0.15*total);
		}
		else if (hardRadio.isSelected()) {
			mineTotal = (int)(0.2*total);
		}
		else {System.out.println("Somehow no difficulty is selected.");}
		
		
		//create new grid with user input
		boardPane = new GridPane();
		for (int i = 0; i < sizeX; i++) {
			ColumnConstraints column = new ColumnConstraints(20);
			column.setFillWidth(true);
			this.boardPane.getColumnConstraints().add(column);
			System.out.println("Column added");
		}
		for (int i = 0; i < sizeY; i++) {
			RowConstraints row = new RowConstraints(20);
			row.setFillHeight(true);
			this.boardPane.getRowConstraints().add(row);
			System.out.println("Row added");
		}
		rightPane.getChildren().add(boardPane);
		boardPane.setStyle("-fx-border-color: #000000");
		boardPane.setMinSize(rightPane.getWidth(), rightPane.getHeight()-50);
		boardPane.getRowConstraints().forEach(i -> i.setPercentHeight(100/boardPane.getRowConstraints().size()));
		boardPane.getColumnConstraints().forEach(i -> i.setPercentWidth(100/boardPane.getColumnConstraints().size()));
		
		this.game = new Board(sizeX,sizeY,mineTotal);
		this.buildBoard();
		
		startTime = System.currentTimeMillis();
		
		//keep track of time
		TimerTask countUp = new TimerTask() {
			public void run() {
				//calculate time elapsed and update timer area
				timeField.setText(Long.toString((System.currentTimeMillis() - startTime) / 1000));
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(countUp, 1000, 1000);
	}
	
	//fills the board and sets the colors for numbers and images for bombs
	public void buildBoard() {
		for(int i = 0; i < game.getCellArray().length; i++) {
			for(int j = 0; j < game.getCellArray()[i].length; j++) {
				Button button = new Button();
				button.setOnAction(btnHandler);
				button.setMaxSize(150, 150);
				boardPane.add(button, i, j);
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
	
	@FXML
	public void btnPressed(ActionEvent event) {
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
				timer.cancel();
				this.clearBoard();
			} else if(game.checkLoss()) {
				resultLabel.setText("You lose!");
				resultLabel.setTextFill(Color.RED);
				resultLabel.setVisible(true);
				timer.cancel();
				this.clearBoard();
			}
		}

	}
	
	//Call this function to reveal buttons that are covering revealed cells.
	public void checkReveal() {
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
	public void clearBoard() {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}
	
	//Reveals all cells on board
	@FXML
	public void clearBtn(ActionEvent event) {
		for(Node a: boardPane.getChildren()) {
			if(a != null && a instanceof Button) {
				a.setVisible(false);
			}
		}
	}
	
	@FXML
	public void clearPressed(ActionEvent event) {				
		boardPane.getChildren().clear();
		timer.cancel();
		timeField.setText("0");
		resultLabel.setText("");
	}
	
	@FXML
	public void showHistory() {
		
	}
	
}
