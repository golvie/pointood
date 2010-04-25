/**
 * 
 */
package ee.ood.planetsys.businesslogic.planetary;

import java.util.ArrayList;

/**
 * 
 * @author Jaroslav Judin
 * Apr 24, 2010
 * @param <T>
 */

public class PlanetarySystem<T extends SpaceObject> extends ArrayList<T> {
	
	private static final long serialVersionUID = 1L;

	public void tick() {
		for ( T item : this )
			item.tick();
	}
	
	public double distance(int planetA, int planetB) {
		
		return this.get(planetA).distance(this.get(planetB));
	}
	
	public String toString() {
		String planets = "";
		for(T p : this)
			planets += p.toString()+"\n";
		return "\n---\n"+planets;
	}
	
	public static void main(String [] args) {
		PlanetarySystem<Planet> ps = new PlanetarySystem<Planet>();
		ps.add(new Planet(5, 0, 0.1));
		ps.add(new Planet(10, 0, 0.1));
		ps.add(new Planet(15, 0, 0.1));
		for( int i=0; i<10; i++)
			ps.tick();
	}
	
}
