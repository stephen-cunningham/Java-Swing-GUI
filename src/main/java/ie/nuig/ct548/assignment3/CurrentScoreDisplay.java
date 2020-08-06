package ie.nuig.ct548.assignment3;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//NOTE: refer to CricketMatchApp.java and AvgScoreDisplay.java for comments that explain the code in this file
public class CurrentScoreDisplay extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private int runs;
	private float overs;
	private int wickets;
	private JLabel runsLabel = new JLabel();
	private JLabel oversLabel = new JLabel();
	private JLabel wicketsLabel = new JLabel();
	
	public void update(Observable o, Object arg) {
		runs = ((CricketData)o).getRuns();
		overs = ((CricketData)o).getOvers();
		wickets = ((CricketData)o).getWickets();
		updateUI();
	}
	
	//this updates the UI (using the values set in the update method)
	private void updateUI() {
		this.runsLabel.setText(Integer.toString(runs));
		this.oversLabel.setText(Float.toString(overs));
		this.wicketsLabel.setText(Integer.toString(wickets));
	}
	
	public CurrentScoreDisplay() {
		super("Current scores");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 2));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(new JLabel("Runs: ", SwingConstants.CENTER));
		this.add(runsLabel);
		this.add(new JLabel("Overs: ", SwingConstants.CENTER));
		this.add(oversLabel);
		this.add(new JLabel("Wickets: ", SwingConstants.CENTER));
		this.add(wicketsLabel);
		this.pack();
		this.setSize(400, 200);
		this.setLocation(100, 400);
		this.setVisible(true);
	}

	public int getRuns() {
		return runs;
	}

	public float getOvers() {
		return overs;
	}

	public int getWickets() {
		return wickets;
	}
}