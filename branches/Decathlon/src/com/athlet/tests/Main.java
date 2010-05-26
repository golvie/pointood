package com.athlet.tests;
import java.io.File;
import java.io.IOException;

import com.athlet.input.InputRead;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class Main {

	/** Simple test harness.   */
	  public static void main (String... aArguments) throws IOException {
	    File testFile = new File("Decathlon_input.txt");
	    InputRead input = new InputRead();
	    System.out.println("Original file contents: \n");
	    input.print(testFile);
	    
	  }

	
}
