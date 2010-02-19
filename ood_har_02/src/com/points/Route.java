package com.points;

import java.util.ArrayList;


/**
 * @author J
 *
 */

public class Route {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	
	public void add(Point p){
		points.add(p);
	}
	
	public boolean remove(Point p){
		if(contains(p)){
			points.remove(this.getIdx(p));
			return true;
		}
		else
			return false;	
	}
	
	public double distance(){
		double length=0;
		for(int i=1; i<points.size(); i++){
			length += points.get(i-1).distance(points.get(i));
		}
		return length;
	}

	private boolean contains(Point p){
		return (getIdx(p)>-1) ? true : false;
	}
	
	private int getIdx(Point p){
		int idx=-1;
		for(int i=0;i<points.size();i++){
			if(p.equalCoord(points.get(i))){
				idx=i;
			}
		}
		return idx;
	}
	
	
	public void print(){
		System.out.print("[");
		for(Point p : points)
			if(getIdx(p)==(points.size()-1))
				System.out.print("("+p+")");
			else
				System.out.print("("+p+"),");
		System.out.print("] Distance: "+this.distance()+"\n");
	}
	
}
