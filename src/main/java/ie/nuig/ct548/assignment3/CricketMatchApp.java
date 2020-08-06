package ie.nuig.ct548.assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CricketMatchApp {
	public static void main(String[] args) {
		//creating an instance of the CricketData class, as well as instances of the two display classes
		final CricketData data = new CricketData();
		AvgScoreDisplay avgDisplay = new AvgScoreDisplay();
		CurrentScoreDisplay currDisplay = new CurrentScoreDisplay();
		
		//assigning the two displays as observers of the observable CricketData object
		data.addObserver(avgDisplay);
		data.addObserver(currDisplay);
		
		final JFrame dataDisplay = new JFrame("Cricket Data");//naming the JFrame that will be used for user input
		
		//these fields will be used below to allow for the user input in the specific fields
		final JFormattedTextField runsField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		final JFormattedTextField oversField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		final JFormattedTextField wicketsField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		
		dataDisplay.setLayout(new GridLayout(4, 2));//implementing the layout for the JFrame
		dataDisplay.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//ensuring the application is terminated when the JFrame is closed
		dataDisplay.add(new JLabel("Runs: ", SwingConstants.RIGHT));//adding JLabels to the rows of the grid, and dealing with alignment
		dataDisplay.add(runsField);//adding the fields that were previously initialised to the JFrame
		dataDisplay.add(new JLabel("Overs: ", SwingConstants.RIGHT));
		dataDisplay.add(oversField);
		dataDisplay.add(new JLabel("Wickets: ", SwingConstants.RIGHT));
		dataDisplay.add(wicketsField);
		JButton button = new JButton("Submit Score");//creating a clickable button
		dataDisplay.add(new JLabel(""));//the JLabel equivalent of System.out.println("");
		dataDisplay.add(button);//adding the button to the JFrame
		dataDisplay.pack();//this 'packs' the window's components based on the preferred sizes
		dataDisplay.setSize(300, 150);//setting the width and height of the JFrame in terms of pixels
		dataDisplay.setLocation(500, 100);//setting the JFrame's location on the screen
		dataDisplay.setVisible(true);//making the window visible
		
		//adding an action listener to the 'Submit Score' button. This will 'listen' for a mouse click
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here, the value in the fields are cast to Number objects, and the integer value of these objects are retrieved
				int r = ((Number)runsField.getValue()).intValue();
				float o = ((Number)oversField.getValue()).floatValue();
				int w = ((Number)wicketsField.getValue()).intValue();
				data.setScore(r, o, w);//the retrieved integer values are passed to the setScore method of the CricektData class
			}
		});
	}
}