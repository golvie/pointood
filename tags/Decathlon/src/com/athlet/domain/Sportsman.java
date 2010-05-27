package com.athlet.domain;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
@SuppressWarnings("unchecked")
public class Sportsman implements Comparable {

	
	private String name;
	private ArrayList<Result> results;
	private int totalScore;
	private String place;

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
	
	public void setTotalScore(int score) {
		this.totalScore = score;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return place;
	}

	@Override
	public String toString() {
		
		StringBuilder response = new StringBuilder();
		response.append("Sportsmen [name=" + name + ", results=\n");
		if (getPlace() != null)
			response.append("Place: "+getPlace()+"\n");
		for (Result res : results)
			response.append("\t"+res+"\n");
		if (getTotalScore()!=0)
			response.append("Total: "+getTotalScore()+"\n");
		response.append("]");
		return response.toString();
	}

	@Override
	public int compareTo(Object anotherMan) throws ClassCastException {
		if (!(anotherMan instanceof Sportsman))
		      throw new ClassCastException("A Person object expected.");
		    int anotherManScore = ((Sportsman) anotherMan).getTotalScore();  

		return  anotherManScore - this.getTotalScore();
	}

}
