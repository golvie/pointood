/**
 * 
 */
package com.athlet.logic;

import java.util.ArrayList;
import java.util.Collections;

import com.athlet.domain.Sportsman;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class PlaceHolder {

	@SuppressWarnings("unchecked")
	public ArrayList<Sportsman> sortSportsmans(ArrayList<Sportsman> men) {
		
		Collections.sort(men);
		
		for (int i=0; i<men.size(); i++) {
			if (i>0) {
				if (men.get(i-1).getTotalScore() == men.get(i).getTotalScore()) {
					men.get(i-1).setPlace(men.get(i-1).getPlace()+"-"+(i+1));
					men.get(i).setPlace(men.get(i-1).getPlace());
				} else {
					men.get(i).setPlace((i+1)+"");
				}
			} else {
				men.get(i).setPlace(i+1+"");
			}
		}
		
		return men;
	}
	
}
