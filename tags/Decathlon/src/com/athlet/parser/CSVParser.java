/**
 * 
 */
package com.athlet.parser;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.athlet.domain.Sportsman;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class CSVParser {

	public static final String VALUE_SEPARATOR = ";";
	
	public ArrayList<Sportsman> 
		getSportsmenList(ArrayList<String> contents){

	ArrayList<Sportsman> men = new ArrayList<Sportsman>();
	
	for (String line : contents) {
	  men.add(getSportsmen(line));
	}
	
	return men;
	}
	
	public Sportsman getSportsmen(String line){
	
	String[] x = Pattern.compile(VALUE_SEPARATOR).split(line);
	
	Sportsman man = new Sportsman();
	
	try {
	for (int i=0; i<x.length; i++) {
		  if (i==0)
			  man.setName(x[i]);
		  else
			  man.addResult(ResultParser.parse(x[i], i));
	  }
	} catch (NumberFormatException e) {
	e.printStackTrace();
	}
	
	return man;
}


	
	
}
