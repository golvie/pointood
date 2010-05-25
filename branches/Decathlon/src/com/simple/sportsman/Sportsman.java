package com.simple.sportsman;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class Sportsman {

	
	private String name;
	private ArrayList<Result> results;

	public Sportsman() {
		results = new ArrayList<Result>();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public ArrayList<Result> getResults() {
		return results;
	}
	
	public void addResult(Result res) {
		getResults().add(res);
	}
	
	@Override
	public String toString() {
		return "Sportsmen [name=" + name + ", results=" + results + "]";
	}
	
}
