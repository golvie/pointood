package com.points;

import java.util.ArrayList;


/**
 * @author J
 *
 */

public class Route {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	public void print(){
		System.out.print("[");
		for(Point p : points)
			if(getIdx(p)==(points.size()-1))
				System.out.print("("+p+")");
			else
				System.out.print("("+p+"),");
		System.out.print("] Distance: "+this.length()+"\n");
	}
	
	public void add(Point p){
		points.add(p);
	}
	
	private int getIdx(Point p){
		int idx=-1;
		for(int i=0;i<points.size();i++){
			if(p.eqCrd(points.get(i))){
				idx=i;
			}
		}
		return idx;
	}
	
	public boolean remove(Point p){
		//if(p.eqCrd(points.get(count)) || p.eqCrd(points.get(0))){
		if(getIdx(p)>-1){
			points.remove(this.getIdx(p));
			return true;
		}
		else
			return false;
		
	}
	
	public double length(){
		double length=0;
		for(int i=1; i<points.size(); i++){
			length += points.get(i-1).distance(points.get(i));
		}
		return length;
	}

	
}
