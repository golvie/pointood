package com.athlet.domain;
/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class Result {

	private String name;
	private double meters;
	private double sec;
	private int score;
	
	public void setMeters(double meters) {
		this.meters = meters;
	}
	public double getMeters() {
		return meters;
	}
	public void setSec(double sec) {
		this.sec = sec;
	}
	public double getSec() {
		return sec;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		
		String res="Result [";
		if (meters != 0)
			res += "meters=" + meters;
		else if (sec != 0)
			res += "seconds=" + sec;
		if (score != 0)
			res += ", score=" + score;
		res += "]";
		return res;
	}
	
}
