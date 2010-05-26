package com.athlet.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.athlet.parser.ParseResult;
import com.athlet.sportsman.Sportsman;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class InputRead {

	/**
	  * Fetch the entire contents of a text file, and return it in a String.
	  * This style of implementation does not throw Exceptions to the caller.
	  *
	  * @param aFile is a file which already exists and can be read.
	  */
	  public ArrayList<Sportsman> getContents(File aFile) {
	    //...checks on aFile are elided
	    ArrayList<String> contents = new ArrayList<String>();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null){
	          contents.add(line);
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return getSportsmenList(contents);
	  }

	  public ArrayList<Sportsman> 
	  			getSportsmenList(ArrayList<String> contents){
		  
		  ArrayList<Sportsman> men = new ArrayList<Sportsman>();
		  
		  for (String line : contents) {
			  men.add(getSportsmen(line));
		  }
		  
		  return men;
	  }
	  
	  public Sportsman getSportsmen(String line){
		  
		  String[] x = Pattern.compile(";").split(line);
		  
		  //for (int i=0; i<x.length; i++)
			//  System.out.println(x[i] +" "+i);
		  
		  Sportsman man = new Sportsman();
		  
		  try {
			for (int i=0; i<x.length; i++) {
				  if (i==0)
					  man.setName(x[i]);
				  else
					  man.addResult(ParseResult.parse(x[i], i));
			  }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		  
		  return man;
	  }
	
	  public void print(File aFile) {
		  
		  ArrayList<Sportsman> men = getContents(aFile);
		  
		  for(Sportsman man : men) {
			  System.out.println("Sportsman: "+man.getName());
			  System.out.println("Results: ");
			  for (int i=0; i<man.getResults().size(); i++){
				  System.out.println(man.getResults().get(i));
			  }
			  //System.out.println("\n");
		  }
	  }
	  
}
