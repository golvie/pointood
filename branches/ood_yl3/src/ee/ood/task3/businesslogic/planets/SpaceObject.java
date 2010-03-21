/**
 * 
 */
package ee.ood.task3.businesslogic.planets;

import ee.ood.task3.businesslogic.geom.Point;


/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 */
public abstract class SpaceObject extends Point {

	public abstract void tick();
	protected SpaceObject(double x, double y){
		super(x,y);
	}
}
