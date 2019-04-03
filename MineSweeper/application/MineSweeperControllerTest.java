package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


class MineSweeperControllerTest {
	Board game;
	Button surrenderbtn;
	
	@Before
	
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Minesweeper");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/MineSweeper.fxml"));
			AnchorPane mineLayout = (AnchorPane) loader.load();
			Scene scene = new Scene (mineLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	private static void launch(String[] args) {
		// TODO Auto-generated method stub
	}

	@Test
	void testCheckReveal() {
		Cell testCell = new Cell(true,true,false,1);
		assertTrue(testCell.checkRevealed());
	}

	@Test
	void testClearBoard() {
			assertNull(game);
		}
		
		
	}

