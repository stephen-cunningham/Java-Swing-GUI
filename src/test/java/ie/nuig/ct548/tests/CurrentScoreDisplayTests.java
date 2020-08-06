package ie.nuig.ct548.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import ie.nuig.ct548.assignment3.AvgScoreDisplay;
import ie.nuig.ct548.assignment3.CricketData;
import ie.nuig.ct548.assignment3.CurrentScoreDisplay;

public class CurrentScoreDisplayTests {
	//testing the constructors of each class
	@Test
	public void constructorsTest() {
		CricketData cD = new CricketData();
		CurrentScoreDisplay cSD = new CurrentScoreDisplay();
		AvgScoreDisplay aSD = new AvgScoreDisplay();
		
		assertNotNull(cD);
		assertNotNull(cSD);
		assertNotNull(aSD);
	}
	
	//testing that the observer pattern works, i.e. if the update method works correctly when the setScore method (which notifies observers) is called
	@Test
	public void updateTest() {
		CricketData cD = new CricketData();
		CurrentScoreDisplay cSD = new CurrentScoreDisplay();
		AvgScoreDisplay aSD = new AvgScoreDisplay();
		
		cD.addObserver(cSD);
		cD.addObserver(aSD);
		
		cD.setScore(1, 2, 3);
		
		assertEquals(1, cSD.getRuns(), 0);
		assertEquals(1.0/2.0, aSD.getRPO(), 0);
	}
}