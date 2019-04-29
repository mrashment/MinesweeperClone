package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public void winLoss() {
		 int win = 0;
		 int loss = 0;
		 int win2 = 0;
		 int loss2 = 0;
		 int win3 = 0;
		 int loss3 = 0;
		    try {
		        BufferedReader reader = new BufferedReader(new FileReader("MineSweeperResults.txt"));
		        String line = reader.readLine();
		        while (line != null)                 
		        {
		            try {
		                String wins = line.trim();   
		                System.out.println(wins);
		                if ( wins.contentEquals("Win"))                       
		                { 
		                    win++;
		                    System.out.println("Win added");
		                }
		                else {
		                	loss++;
		                }
		                
		            } catch (NumberFormatException e1) {
		            }
		            line = reader.readLine();
		        }
		        reader.close();

		    } catch (IOException ex) {
		        System.err.println("ERROR reading scores from file");
		    }
		    
		    //System.out.println("Wins: " + win );
		    //System.out.println("Losses: " + loss);
		    easyWin.setText(Integer.toString(win));
		    easyLoss.setText(Integer.toString(loss));
		
		    try {
		        BufferedReader reader = new BufferedReader(new FileReader("MineSweeperResults2.txt"));
		        String line = reader.readLine();
		        while (line != null)                 
		        {
		            try {
		                String wins = line.trim();   
		                if ( wins.contentEquals("Win"))                       
		                { 
		                    win2++; 
		                }
		                else {
		                	loss2++;
		                }
		                
		            } catch (NumberFormatException e1) {
		            }
		            line = reader.readLine();
		        }
		        reader.close();

		    } catch (IOException ex) {
		        System.err.println("ERROR reading scores from file");
		    }
		    
		    //System.out.println("Wins: " + win );
		    //System.out.println("Losses: " + loss);
		    mediumWin.setText(Integer.toString(win2));
		    mediumLoss.setText(Integer.toString(loss2));
		
		    try {
		        BufferedReader reader = new BufferedReader(new FileReader("MineSweeperResults3.txt"));
		        String line = reader.readLine();
		        while (line != null)                 
		        {
		            try {
		                String wins = line.trim();   
		                if ( wins.contentEquals("Win"))                       
		                { 
		                    win3++; 
		                }
		                else {
		                	loss3++;
		                }
		                
		            } catch (NumberFormatException e1) {
		            }
		            line = reader.readLine();
		        }
		        reader.close();

		    } catch (IOException ex) {
		        System.err.println("ERROR reading scores from file");
		    }
		    
		    //System.out.println("Wins: " + win );
		    //System.out.println("Losses: " + loss);
		    hardWin.setText(Integer.toString(win3));
		    hardLoss.setText(Integer.toString(loss3));
		    
		
		
		}
	
	public void wipeHistory(ActionEvent event) {
		easyHigh.setText("No Data");
		mediumHigh.setText("No Data");
		hardHigh.setText("No Data");
		easyWin.setText("0");
		easyLoss.setText("0");
		mediumWin.setText("0");
		mediumLoss.setText("0");
		hardWin.setText("0");
		hardLoss.setText("0");
		File bestTimes = new File("BestTimes.txt");
		try (PrintWriter timeWriter = new PrintWriter(bestTimes)) {
			timeWriter.print("10000\n10000\n10000\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		File history = new File("MineSweeperResults.txt");
		history.delete();
		File history2 = new File("MineSweeperResults2.txt");
		history2.delete();
		File history3 = new File("MineSweeperResults3.txt");
		history3.delete();
	}
}
