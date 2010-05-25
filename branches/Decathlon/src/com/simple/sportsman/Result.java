package com.simple.sportsman;
/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class Result {

	private double meters;
	private double sec;
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String res="Result [";
		if (meters != 0)
			res += "meters=" + meters;
		if (sec != 0 && meters != 0)
			res += ", ";
		if (sec != 0)
			res += "sec=" + sec;
		res += "]";
		return res;
	}
	
	
	
}
