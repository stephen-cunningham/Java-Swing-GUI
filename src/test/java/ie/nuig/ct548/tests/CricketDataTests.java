package ie.nuig.ct548.tests;

import ie.nuig.ct548.assignment3.AvgScoreDisplay;
import ie.nuig.ct548.assignment3.CricketData;
import ie.nuig.ct548.assignment3.CurrentScoreDisplay;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketDataTests {
	//testing if the adding and deleting of both types of observers to the CricketData object is working correctly
	@Test
	public void addRemoveObservers() {
		CricketData cD = new CricketData();
		CurrentScoreDisplay cSD = new CurrentScoreDisplay();
		AvgScoreDisplay aSD = new AvgScoreDisplay();
		
		assertEquals(0, cD.countObservers());//checking if there are currently no observers
		
		//checking if the addObserver operation works
		cD.addObserver(cSD);
		assertEquals(1, cD.countObservers());
		cD.addObserver(cSD);
		assertEquals(1, cD.countObservers());//this tests whether you can add the same observer twice
		cD.addObserver(aSD);
		assertEquals(2, cD.countObservers());
		
		//checking if the deleteObserver operation works
		cD.deleteObserver(cSD);
		assertEquals(1, cD.countObservers());
		cD.deleteObserver(cSD);
		assertEquals(1, cD.countObservers());//tests whether you can delete the same observer twice
		cD.deleteObserver(aSD);
		assertEquals(0, cD.countObservers());
		cD.deleteObserver(aSD);
		assertEquals(0, cD.countObservers());//tests whether you can delete observers when there are none assigned
		
		//checking the deleteObservers operation, which deletes all observers rather than just one, works
		cD.addObserver(cSD);
		cD.addObserver(aSD);
		assertEquals(2, cD.countObservers());
		cD.deleteObservers();//deleting both observers
		assertEquals(0, cD.countObservers());
	}
	
	//testing the setter and getters
	@Test
	public void setterGetterTest() {
		CricketData cD = new CricketData();
		cD.setScore(1, 2, 3);
		
		/*here, the expected values (1, 2 and 3) are compared with their respective returns values to check if they are the same
		 * if they are, then the setter and getters are working correctly
		 * the 0 means there can be no difference between the expected value and actual value
		 */
		assertEquals(1, cD.getRuns(), 0);
		assertEquals(2, cD.getOvers(), 0);
		assertEquals(3, cD.getWickets(), 0);
	}
}