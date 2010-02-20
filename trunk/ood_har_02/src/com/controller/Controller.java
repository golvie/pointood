package com.controller;

import com.points.Route;


/**
 * @author J
 *
 */
public class Controller implements Control<Route> {

	private Route route = new Route();
	
	@Override
	public void add(double x, double y){
		route.add(x,y);
	}
	
	@Override
	public void remove(double x, double y){
		if(route.remove(x,y))
			System.out.println("The point: "+x+"; "+y+"; is removed");
		else
			System.out.println("The point: "+x+"; "+y+" cannot be removed. It isn't in the Route.");
	}
	
	@Override
	public double distance(){
		return route.distance();
	}
	
	public void print(){
		route.print();
	}

}
