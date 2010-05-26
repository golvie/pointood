package com.athlet.parser;
import com.athlet.sportsman.Result;


/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class ParseResult {

	public static Result parse(String line, int n) {
		Result res = new Result();

		try {
			if (n==10) {	// track event
				res.setMin(Double.valueOf(line.substring(0, 1)));
				res.setSec(Double.valueOf(line.substring(2)));
			} else if (n==1 || n==5 || n==6) {  // track event
				res.setSec(Double.valueOf(line));
			} else {  // field event
				res.setMeters(Double.valueOf(line));
			}
				
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
}
