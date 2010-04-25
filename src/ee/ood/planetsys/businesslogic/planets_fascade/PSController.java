/**
 * 
 */
package ee.ood.planetsys.businesslogic.planets_fascade;

import ee.ood.planetsys.businesslogic.flightplan.ChangeDirection;
import ee.ood.planetsys.businesslogic.flightplan.ChangeSpeed;
import ee.ood.planetsys.businesslogic.flightplan.Wait;
import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;
import ee.ood.planetsys.businesslogic.planetary.Planet;
import ee.ood.planetsys.businesslogic.planetary.PlanetarySystem;
import ee.ood.planetsys.businesslogic.planetary.SpaceObject;
import ee.ood.planetsys.businesslogic.planetary.SpaceShip;

/**
 * @author Jaroslav Judin
 * Mar 19, 2010
 */
public class PSController {
	
	private PlanetarySystem<SpaceObject> sys;
	private final static double T = 4;
	private int last_operated_spaceship = 0;
	private int tick_counter = 0;
	public void make_solar_system() {
		
		tick_counter = 0;
		this.sys = new PlanetarySystem<SpaceObject>();
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
			getPlanetarySystem().add(new Planet(astro_data[i][1], 0.0, (2 * Math.PI) / (astro_data[i][0] * T)));
		
	}
	
	public PlanetarySystem<SpaceObject> getPlanetarySystem() {
		return this.sys;
	}
	
	public int getCounter() {
		return tick_counter;
	}
	
	public void tick() {
		getPlanetarySystem().tick();
		tick_counter++;
	}
	
	public void multi_tick(int N) {	
		N = 100;
		for (int i=0; i<N; i++)
			tick();
	}
	
	public SpaceShip launch(int planet_id , double dx, double dy) {
		if(getPlanetarySystem().size() >= planet_id && planet_id > -1) {	
			Planet pl = (Planet) getPlanetarySystem().get(planet_id);
			SpaceShip sp = new SpaceShip( pl.x(), pl.y(), dx, dy );
			getPlanetarySystem().add(sp);
			return sp;
		} else 
			return new SpaceShip(0,0,0,0);
	}
	
	public OperatedSpaceShip launchOperated(int planet_id , double dx, double dy) {
		if(getPlanetarySystem().size() >= planet_id && planet_id > -1) {	
			Planet pl = (Planet) getPlanetarySystem().get(planet_id);
			OperatedSpaceShip sp = new OperatedSpaceShip( pl.x(), pl.y(), dx, dy );
			last_operated_spaceship = getPlanetarySystem().size();
			getPlanetarySystem().add(sp);
			return sp;
		} else 
			return new OperatedSpaceShip(0,0,0,0);
	}
	
	public void operatedChangeSpeed(double factor) {
		if (last_operated_spaceship > 0) {
			OperatedSpaceShip ship = (OperatedSpaceShip) getPlanetarySystem().get(last_operated_spaceship);
			ship.getPlan().addCommand(new ChangeSpeed(ship , factor));
		}
	}
	
	public void operatedChangeDirection(double angle) {
		if (last_operated_spaceship > 0) {
			OperatedSpaceShip ship = (OperatedSpaceShip) getPlanetarySystem().get(last_operated_spaceship);
			ship.getPlan().addCommand(new ChangeDirection(ship , angle));
		}
	}
	
	public void operatedWait(int ticks) {
		if (last_operated_spaceship > 0) {
			OperatedSpaceShip ship = (OperatedSpaceShip) getPlanetarySystem().get(last_operated_spaceship);
			ship.getPlan().addCommand(new Wait(ship , ticks));
		}
			
	}
	
}
