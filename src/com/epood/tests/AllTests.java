/**
 * 
 */
package com.epood.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @author Jaroslav Judin
 * Apr 26, 2010
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.epood.tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestOrder.class);
		suite.addTestSuite(TestOrderBusinessValidator.class);
		//$JUnit-END$
		return suite;
	}
	
	public static void main(String[] args){
		TestRunner.run(suite());
	}

}
