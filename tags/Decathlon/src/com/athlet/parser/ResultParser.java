package com.athlet.parser;
import com.athlet.domain.Result;


/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class ResultParser {

	public static final String[] EVENTS = {"100m", "Long Jump", "Shot Put", "High Jump", "400m", 
		"110 Hurdles", "Discus Throw", "Pole Vault", "Javelin Throw", "1500m"};
	
	public static Result parse(String line, int n) {
		Result res = new Result();
		res.setName(EVENTS[n-1]);
		
		try {
			if (n==10) {	// track event
				res.setSec( Double.valueOf(line.substring(0, 1))*60 // minutes into seconds
						+ Double.valueOf(line.substring(2)));
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
