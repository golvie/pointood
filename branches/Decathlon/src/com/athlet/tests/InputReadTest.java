/**
 * 
 */
package com.athlet.tests;

import java.io.File;

import com.athlet.input.InputRead;

import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class InputReadTest extends TestCase {

	private InputRead input;
	private File testFile;
	
	/**
	 * @param name
	 */
	public InputReadTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		input = new InputRead();
		testFile = new File("Decathlon_input.txt");
	}

	
	protected void tearDown() throws Exception {
		super.tearDown();
		input = null;
		testFile = null;
	}

	/**
	 * Test method for {@link com.athlet.input.InputRead#getContents(java.io.File)}.
	 */
	public final void testGetContents() {
		
	}

	/**
	 * Test method for {@link com.athlet.input.InputRead#getSportsmenList(java.util.ArrayList)}.
	 */
	public final void testGetSportsmenList() {
		
	}

}
