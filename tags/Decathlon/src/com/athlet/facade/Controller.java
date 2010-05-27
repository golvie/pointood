/**
 * 
 */
package com.athlet.facade;

import java.io.File;
import java.util.ArrayList;

import com.athlet.domain.Sportsman;
import com.athlet.input.InputRead;
import com.athlet.logic.PlaceHolder;
import com.athlet.logic.PointsCounter;
import com.athlet.output.XMLBuilder;
import com.athlet.parser.CSVParser;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class Controller {

	private File testFile;
	private ArrayList<Sportsman> men;
	
	public Controller(String fileName) {
		testFile = new File(fileName);
		makeSportsmenList();
	}

	public void makeSportsmenList() {
		InputRead input = new InputRead();
		CSVParser csv = new CSVParser();
		men = csv.getSportsmenList(input.getContents(testFile));
	}
	
	public ArrayList<Sportsman> getSportsmans() {
		return men;
	}
	
	public void addPoints() {
		new PointsCounter().countResults(getSportsmans());
	}
	
	public void sortByPoints() {
		new PlaceHolder().sortSportsmans(getSportsmans());
	}
	
	public void buildXML() {
		new XMLBuilder(getSportsmans());
	}
	
	public void printList() {
		for (Sportsman man : getSportsmans()) {
	    	System.out.println(man);
	    }
	}
	
}
