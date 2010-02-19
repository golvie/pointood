package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author J
 *
 */
public class input {

	
	
	public static double getCoord(String c) {
		double coord;
		String str="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter coordinate "+c+": ");
		do {
			try {
				str = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			try {
				coord = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				System.out.println("Error value. Enter "+c+" once again:");
				coord = Double.NEGATIVE_INFINITY;
			}
		} while (coord  == Double.NEGATIVE_INFINITY);
		
		return coord;
	}

	public static String getFlag() {
		String str="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter 's'-stop, 'd'-route distance, 'a'-add or  'r'-remove:");
		do {
			try {
				str = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			if(!str.equalsIgnoreCase("a") && !str.equalsIgnoreCase("r")
					&& !str.equalsIgnoreCase("s")&& !str.equalsIgnoreCase("d")) {
				System.out.println("Only 'S', 'A', 'D' or 'R':");
				str="";
			}
		} while (str.equals(""));
		return str;
	}
	
}
