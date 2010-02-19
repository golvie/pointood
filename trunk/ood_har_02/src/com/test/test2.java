package com.test;

import com.controller.Controller;

public class test2 {
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
		c.add(0, 0);
		c.print();
		c.add(1, 10);
		c.print();
		c.add(-5, 6);
		c.print();
		c.add(10, 2);
		c.print();
		
		c.remove(-100, 0);
		c.print();
		
		c.remove(1, 10);
		c.print();
		c.remove(-5, 6);
		System.out.println("Distance: "+ c.distance());
	}
}
