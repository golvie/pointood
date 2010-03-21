/**
 * 
 */
package ee.ood.task3.businesslogic.planets;

import java.util.ArrayList;
import java.util.List;

import ee.ood.task3.businesslogic.geom.PointSimulationElement;

//import ee.ood.task3.businesslogic.geom.SimulationElement;

/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 * @param <T>
 */
public class PlanetarySystem<T extends PointSimulationElement> {
	
	private List<T> elements;
	
	public PlanetarySystem() {
		elements = new ArrayList<T>();
	}
	
	public void tick() {
		for ( T item : elements )
			item.tick();
	}
	
	public double distance(int planetA, int planetB) {
		
		return elements.get(planetA).distance(elements.get(planetB));
	}
	
	public String toString() {
		String planets = "";
		for(T p : elements)
			planets += p.toString()+"\n";
		return "\n---\n"+planets;
	}
	
	public void append(T element) {
		elements.add(element);
	}
	public T get(int id){
		return elements.get(id);
	}
	
	public int len() {
		return elements.size();
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
