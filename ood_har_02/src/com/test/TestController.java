/**
 * 
 */
package com.test;

import com.controller.Control;
import com.controller.Controller;

import junit.framework.TestCase;

/**
 * @author J
 *
 */
public class TestController extends TestCase {

	/**
	 * @param name
	 */
	
	private Controller c;
	
	public TestController(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		c = new Controller();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		c = null;
	}

	/**
	 * Test method for {@link com.controller.Controller#add(double, double)}.
	 */
	public final void testAdd() {
		System.out.println("testAdd() ");
		System.out.print("before adding: ");
		c.print();
		c.add(3, 4);
		c.add(-3, -4);
		c.add(5, 7);
		System.out.print("after adding: ");
		c.print();
		System.out.println("<=================>");
	}

	/**
	 * Test method for {@link com.controller.Controller#remove(double, double)}.
	 */
	public final void testRemove() {
		c.remove(5, 7);
	}

	/**
	 * Test method for {@link com.controller.Controller#distance()}.
	 */
	public final void testDistance() {
		c.distance();
	}

}
