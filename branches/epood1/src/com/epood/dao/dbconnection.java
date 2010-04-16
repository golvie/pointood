package com.epood.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * @author J
 *
 */
public class dbconnection {

	String pwd="";
	String usr="";
	String url="";
	Connection db_connection ;
	
	
	public dbconnection() {

		try{
			ResourceBundle bundle = ResourceBundle.getBundle("DBConnection");
		    Class.forName(bundle.getString("Driver"));
		    this.url = bundle.getString("url");
		    this.usr = bundle.getString("usr");
		    this.pwd = bundle.getString("pwd");
		    //this.db_connection = DriverManager.getConnection(this.url, this.usr, this.pwd);
		    this.db_connection = DriverManager.getConnection(this.url, this.usr, this.pwd);
		} catch(Exception e) {
			System.out.println("dbconnection.dbconnection():" + e.getMessage());
		}
	}
	
	public Connection getConnection(){
		return this.db_connection;
	}

	public void close(){
		try{
			this.db_connection.close();
		} catch(Exception e) {
			System.out.println("dbconnection.close():" + e.getMessage());
		}
	}

	public void finalize(){
		try{
			System.out.println("finalize():");
		} catch(Exception e) {
			System.out.println("dbconnection.finalize():" + e.getMessage());
		}
	}
}
