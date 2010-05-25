package com.simple.tests;
import java.io.File;
import java.io.IOException;

import com.simple.input.InputRead;

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
	    System.out.println("Original file contents: \n");
	    InputRead.print(testFile);
	    
	  }

	
}
