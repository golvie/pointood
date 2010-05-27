/**
 * 
 */
package com.athlet.logic;

import java.util.ArrayList;

import com.athlet.domain.Result;
import com.athlet.domain.Sportsman;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class PointsCounter {

	private Parameter[] params = {
			new Parameter(25.4347, 18, 1.81),
			new Parameter(0.14354, 220, 1.4),
			new Parameter(51.39, 1.5, 1.05),
			new Parameter(0.8465, 75, 1.42),
			new Parameter(1.53775, 82, 1.81),
			new Parameter(5.74352, 28.5, 1.92),
			new Parameter(12.91, 4, 1.1),
			new Parameter(0.2797, 100, 1.35),
			new Parameter(10.14, 7, 1.08),
			new Parameter(0.03768, 480, 1.85)
	};
	
	private int getTrackPoint(double result, Parameter param) {
		return (int) (param.getA()*Math.pow((param.getB()-result), param.getC()));
	}
	
	private int getFieldPoint(double result, Parameter param) {
		return (int) (param.getA()*Math.pow((result-param.getB()), param.getC()));
	}
	
	public ArrayList<Sportsman> countResults(ArrayList<Sportsman> men) {
		
		//Sportsman man;
		
		for (int i=0; i<men.size(); i++) {
			//man = men.get(i);
			//man = getTotalScore(man);
			//men.set(i, man);
			
			getTotalScore(men.get(i));
		}
		
		return men;
	}

	/**
	 * @param man
	 * @return
	 */
	public Sportsman getTotalScore(Sportsman man) {
		
		int score = 0;
		int tempScore = 0;
		
		for (int i=0; i<man.getResults().size(); i++) {
			Result res = man.getResults().get(i);
			Parameter param = params[i];
			if (res.getSec() != 0) {
				tempScore = getTrackPoint(res.getSec(), param);
			} else if (i==1 || i==3 || i==7) {
				tempScore = getFieldPoint(res.getMeters()*100, param); // formula uses sm
			} else {
				tempScore = getFieldPoint(res.getMeters(), param);
			}
			man.getResults().get(i).setScore(tempScore);
			score += tempScore;
		}
		
		man.setTotalScore(score);
		
		return man;
	}
	
}
