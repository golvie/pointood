package com.athlet.sportsman;
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
	private double min;
	
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
	public void setMin(double min) {
		this.min = min;
	}
	public double getMin() {
		return min;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String res="Result [";
		if (meters != 0)
			res += "meters=" + meters;
		else if (sec != 0 && min != 0)
			res += "min="+min+", sec=" + sec;
		else if (sec != 0)
			res += "sec=" + sec;
		res += "]";
		return res;
	}
	
	
	
}
