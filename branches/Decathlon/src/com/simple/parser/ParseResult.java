package com.simple.parser;
import com.simple.sportsman.Result;


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
			if (n==10) {	
				res.setMeters(Double.valueOf(line.substring(0, 1)));
				res.setSec(Double.valueOf(line.substring(2)));
			} else if (n==1 || n==5 || n==6){
				res.setSec(Double.valueOf(line));
			} else {
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
