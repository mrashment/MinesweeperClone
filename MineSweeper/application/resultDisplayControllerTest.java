package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

class resultDisplayControllerTest {
	@FXML
	private Button refresh;
	@FXML
	private Label easyHigh;
	@FXML
	private Label mediumHigh;
	@FXML
	private Label hardHigh;
	@FXML
	private Label easyWin;
	@FXML
	private Label easyLoss;
	@FXML
	private Label mediumWin;
	@FXML
	private Label mediumLoss;
	@FXML
	private Label hardWin;
	@FXML
	private Label hardLoss;

	 
	 /// The easyWin label only equals win count when it is interacted with (a game is played)
	 
	@Test
	void testEasyWins() {
		int win = 0;
		Label win1 = easyWin;
		assertEquals(win,win1);
	}

	
	 /// The easyLoss label only equals loss count when it is interacted with (a game is played)
	 
	@Test
	void testEasyLoss() {
		int loss = 0;
		Label loss1 = easyLoss;
		assertEquals(loss,loss1);
	}

	
	 /// The mediumWin label only equals win2 count when it is interacted with (a game is played)
	 
	@Test
	void testMediumWins() {
		int win2 = 0;
		Label win = mediumWin;
		assertEquals(win,win2);
	}

	 /// The mediumLoss label only equals loss2 count when it is interacted with (a game is played)
	 
	@Test
	void testMediumLoss() {
		int loss2 = 0;
		Label loss = mediumLoss;
		assertNotEquals(loss, loss2);
	}

	 /// The hardWin label only equals win3 count when it is interacted with (a game is played)
	 
	@Test
	void testHardWins() {
		int win3 = 0;
		Label win = hardWin;
		assertNotEquals(win,win3);
	}

	 /// The hardLoss label only equals loss3 count when it is interacted with (a game is played)
	 
	@Test
	void testHardLoss() {
		int loss3 = 0;
		Label loss = hardLoss;
		assertNotEquals(loss,loss3);
	}

	
}