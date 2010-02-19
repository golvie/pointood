package com.controller;

import com.points.Point;
import com.points.Route;


/**
 * @author J
 *
 */
public class Controller implements Control {

	Route route = new Route();
	
	@Override
	public void add(double x, double y){
		route.add(new Point(x,y));
	}
	
	@Override
	public void remove(double x, double y){
		if(route.remove(new Point(x,y)))
			System.out.println("The point: "+x+"; "+y+"; is removed");
		else
			System.out.println("The point: "+x+"; "+y+" cannot be removed. It isn't in the Route.");
	}
	
	@Override
	public double distance(){
		return route.length();
	}
	
	public void print(){
		route.print();
	}

	
	/*
	public static void main(String[] args) {
	
		Controller c = new Controller();
		c.add(10, 20);
		c.add(17, 0);
		c.add(17, 10);
		
		c.print();
		
		c.remove(17.00,0.00);
		c.remove(17.00,1.00);
		c.print();
		System.out.println("Distance: " +c.distance());
	}
	*/
}
