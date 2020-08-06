package ie.nuig.ct548.assignment3;

import java.util.Observable;

public class CricketData extends Observable {
	private int runs;
	private float overs;
	private int wickets;
	
	public CricketData() {
		this.runs = 0;
		this.overs = 0.0f;
		this.wickets = 0;
	}
	
	public void setScore(int runs, float overs, int wickets) {
		this.runs = runs;
		this.overs = overs;
		this.wickets = wickets;
		/*
		 * marks the object as having been changed. Now, the hasChanged() method returs true when the notifyObservers() method checks it, 
		 * so that the observers can be notified
		 */ 
		this.setChanged();
		this.notifyObservers();//notifies all observers of the changes
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