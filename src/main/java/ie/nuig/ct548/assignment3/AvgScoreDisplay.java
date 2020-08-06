package ie.nuig.ct548.assignment3;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class AvgScoreDisplay extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private double rPO;
	private double rPW;
	private double wPO;
	private JLabel rPOLabel;//this is for the runs per over
	private JLabel rPWLabel;//this is for the runs per wicket
	private JLabel wPOLabel;//this is for the wickets per over
	
	public double getRPO() {
		return rPO;
	}
	
	public double getRPW() {
		return rPW;
	}

	public double getWPO() {
		return wPO;
	}

	//this method is called when the CricketData object is changed (done by the notifyObservers() method)
	public void update(Observable o, Object arg) {
		//the Observable object is cast to a CricketData object here, so that we can use the getters
		//the calculations required for the runs per over, etc. are carried out within the toString operations
		rPO = (double)((CricketData)o).getRuns()/((CricketData)o).getOvers();
		rPW = (double)((CricketData)o).getRuns()/((CricketData)o).getWickets();
		wPO = (double)((CricketData)o).getWickets()/((CricketData)o).getOvers();
		updateUI();
	}
	
	//this updates the UI  (using the values set in the update method)
	public void updateUI() {
		this.rPOLabel.setText(Double.toString(rPO));
		this.rPWLabel.setText(Double.toString(rPW));
		this.wPOLabel.setText(Double.toString(wPO));
	}
	
	/*
	 * the constructor. Most of the comments required to explain the operations in this are provided in the CricketMatchApp.java file. 
	 * Anything that is different in this class is additionally explained below
	 */
	public AvgScoreDisplay() {
		super("Average Scores");//names the JFrame
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 2));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(new JLabel("Runs per over: ", SwingConstants.CENTER));
		//assigning the runs per over data. This is updated every time the submit button is clicked (same with rPW and wPO)
		this.add(this.rPOLabel = new JLabel());
		this.add(new JLabel("Runs per wicket: ", SwingConstants.CENTER));
		this.add(this.rPWLabel = new JLabel());
		this.add(new JLabel("Wickets per over: ", SwingConstants.CENTER));
		this.add(this.wPOLabel = new JLabel());
		this.pack();
		this.setSize(400, 200);
		this.setLocation(500, 400);
		this.setVisible(true);
	}
}