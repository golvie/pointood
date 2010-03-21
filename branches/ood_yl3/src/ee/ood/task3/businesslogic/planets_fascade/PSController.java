/**
 * 
 */
package ee.ood.task3.businesslogic.planets_fascade;

import ee.ood.task3.businesslogic.planets.Planet;
import ee.ood.task3.businesslogic.planets.PlanetarySystem;
import ee.ood.task3.businesslogic.planets.SpaceObject;
import ee.ood.task3.businesslogic.planets.SpaceShip;

/**
 * @author Jaroslav Judin
 * Mar 19, 2010
 */
public class PSController {
	
	private PlanetarySystem<SpaceObject> sys;
	
	public void make_solar_system() {
		
		this.sys = new PlanetarySystem<SpaceObject>();
		int T=4;
		double[][] astro_data = { 
				{87.97/365.26, 0.39},
	            {227.7/365.26, 0.72},
	            {1.0, 1.0},
	            {686.98/365.26, 1.52},
	            {11.86, 5.2},
	            {29.46, 9.54},
	            {84.01, 19.18},
	            {164.81, 30.06},
	            {247.7, 39.75}
		};
		
		for (int i=0; i<astro_data.length; i++)
			this.sys.append(new Planet(astro_data[i][1], 0.0, (2 * Math.PI) / (astro_data[i][0] * T)));
		
		//System.out.println(sys);
	}
	
	public PlanetarySystem<SpaceObject> system() {
		return this.sys;
	}
	
	public void tick() {
		this.system().tick();
	}
	
	public void multi_tick(int N) {	
		N = 100;
		for (int i=0; i<N; i++)
			this.tick();
	}
	
	public SpaceShip launch(int planet_id , double dx, double dy) {
		if(sys.len()>=planet_id) {	
			Planet pl = (Planet) sys.get(planet_id);
			SpaceShip sp = new SpaceShip( pl.x(), pl.y(), dx, dy );
			sys.append(sp);
			return sp;
		} else 
			return new SpaceShip(0,0,0,0);
	}
}
