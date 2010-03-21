/**
 * 
 */
package ee.ood.task3.businesslogic.planets;

import java.util.ArrayList;

import ee.ood.task3.businesslogic.geom.PlanetaryElement;
import ee.ood.task3.businesslogic.geom.PlanetaryElementImpl;

//import ee.ood.task3.businesslogic.geom.SimulationElement;

/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 * @param <T>
 */
@SuppressWarnings("serial")
public class PlanetarySystem<T extends PlanetaryElementImpl> 
	extends ArrayList<T> implements PlanetaryElement {
	
	//private List<T> elements;

	public void tick() {
		for ( T item : this )
			item.tick();
	}
	
	public double distance(int planetA, int planetB) {
		
		return this.get(planetA).distance(this.get(planetB));
	}
	
	public void append(T element) {
		this.add(element);
	}
	
	public int len() {
		return this.size();
	}
	
	public String toString() {
		String planets = "";
		for(T p : this)
			planets += p.toString()+"\n";
		return "\n---\n"+planets;
	}
	
	public static void main(String [] args) {
		PlanetarySystem<Planet> ps = new PlanetarySystem<Planet>();
		ps.append(new Planet(5, 0, 0.1));
		ps.append(new Planet(10, 0, 0.1));
		ps.append(new Planet(15, 0, 0.1));
		for( int i=0; i<10; i++)
			ps.tick();
	}
	
}
