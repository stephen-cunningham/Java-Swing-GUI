The main() method is in the assignment3-19103284\src\main\java\ie\nuig\ct548\assignment3\CricketMatchApp.java file.
There are 2 packages:
1. assignment3-19103284\src\main\java\ie\nuig\ct548\assignment3 - this contains:
	CricketData.java
	CurrentScoreDisplay.java
	AvgScoreDisplay.java
	CricketMatchApp.java (main method) - this is the application and where to run the program
2. assignment3-19103284\src\test\java\ie\nuig\ct548\tests - this contains:
	CricketDataTests.java
	CurrentScoreDisplayTests.java
	AvgScoreDisplayTests.java

Most required explanations for the code are specified within each file. Anything that isn't explained within is outlined below: 

Since CurrentScoreDisplay and AvgScoreDisplay are both UI's that take data from CricketData, they both extend JFrame and implement Observer.
CricketData extends Observable, which allows it to be observed by AvgScoreDisplay and CurrentScoreDisplay.

CricketData.java:
Observable has pre-written code to store observers in a LinkedHashSet, so since CricketData extends Observable, there is no need to include a list
	of observers in its constructor.
The score setter calls the setChanged() operation, which marks the observable as changed. Now, hasChanged() returns true and the update() methods
	in the observer classes (the displays) can run when the notifyObservers() operation is called in the score setter.

CurrentScoreDisplay.java & AvgScoreDisplay.java:
The update method casts the Observable object o to CricketData so that the CricketData getters can be used.
The Object arg here is null, since notifyObservers() passes no arguments from within the two observer classes.
The updateUI() method is called from within the update() method, which is responsible for updating the UI by setting the JLabel values.
The constructor calls the super(String title) constructor of the JFrame super for creating a Frame with a specified title.