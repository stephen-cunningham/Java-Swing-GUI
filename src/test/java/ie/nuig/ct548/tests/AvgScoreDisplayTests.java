package ie.nuig.ct548.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import ie.nuig.ct548.assignment3.AvgScoreDisplay;
import ie.nuig.ct548.assignment3.CricketData;
import ie.nuig.ct548.assignment3.CurrentScoreDisplay;

//testing the instantiation of an object of the class
public class AvgScoreDisplayTests {
	//testing if the runs per overs, runs per wickets, and wickets per overs calculations work correctly
	@Test
	public void avgCalcTests() {
		CricketData cD = new CricketData();
		AvgScoreDisplay aSD = new AvgScoreDisplay();
		
		cD.addObserver(aSD);
		
		cD.setScore(45, 7, 2);
		
		assertEquals(45.0/7.0, aSD.getRPO(), 0);
		assertEquals(45.0/2.0, aSD.getRPW(), 0);
		assertEquals(2.0/7.0, aSD.getWPO(), 0);
	}
	
	//testing the getters in both the display classes
	@Test
	public void displaysGettersTests() {
		CricketData cD = new CricketData();
		CurrentScoreDisplay cSD = new CurrentScoreDisplay();
		AvgScoreDisplay aSD = new AvgScoreDisplay();
		
		cD.addObserver(cSD);
		cD.addObserver(aSD);
		
		cD.setScore(1, 2, 3);
		
		assertEquals(1, cSD.getRuns(), 0);
		assertEquals(2, cSD.getOvers(), 0);
		assertEquals(3, cSD.getWickets(), 0);
		
		assertEquals(1.0/2.0, aSD.getRPO(), 0);
		assertEquals(1.0/3.0, aSD.getRPW(), 0);
		assertEquals(3.0/2.0, aSD.getWPO(), 0);
	}
}