/**
 * 
 */
package ee.ood.planetsys.tests;

//import junit.awtui.TestRunner;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.swingui.TestRunner;


/**
 * @author Jaroslav Judin
 * Mar 21, 2010
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for ee.ood.task3.tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestPlanet.class);
		suite.addTestSuite(TestPS.class);
		suite.addTestSuite(TestSpaceShip.class);
		suite.addTestSuite(TestOperatedSpaceShip.class);
		//$JUnit-END$
		return suite;
	}
	
	public static void main(String [] args) {
		
		TestRunner.run(AllTests.class);		
	}

}
