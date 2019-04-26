package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;

public class resultDisplayController {
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
	
	
	public void seteasyHigh(String s) {
		easyHigh.setText(s);
	 }
		
	
	
	public void setmediumHigh(String s) {
		mediumHigh.setText(s);
	}
	
	
	public void sethardHigh(String s) {
		hardHigh.setText(s);
	}
	
	
	public void seteasyWin(String s) {
		easyWin.setText(s);
	}
	
	
	public void seteasyLoss(String s) {
		easyLoss.setText(s);
	}
	
	
	public void setmediumWin(String s) {
		mediumWin.setText(s);
	}
	
	
	public void setmediumLoss(String s) {
		mediumLoss.setText(s);
	}
	
	
	public void sethardWin(String s) {
		hardWin.setText(s);
	}
	
	
	public void sethardLoss(String s) {
		hardLoss.setText(s);
	}
	

	public void wipeHistory(ActionEvent event) {
		easyHigh.setText("0");
		mediumHigh.setText("0");
		hardHigh.setText("0");
		easyWin.setText("0");
		easyLoss.setText("0");
		mediumWin.setText("0");
		mediumLoss.setText("0");
		hardWin.setText("0");
		hardLoss.setText("0");
	}
}
