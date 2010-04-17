package com.epood.dao ;

import java.sql.* ;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.epood.log.MyLogger;
import com.epood.model.domain.Customer;

//import org.apache.commons.codec.binary.Hex;

public class AuthUser {

	 static String sql = "" ;
     DBconnection dbconnection ;
	 java.sql.Connection myConnection ;
	 ResultSet QueryResult ;
	 Statement st ;
	 int record_cnt = 0;
	 Customer customer = null;

	 public static void main( String args[] ){
		 AuthUser UsAuth = new AuthUser();
		 Customer cust = UsAuth.getUserFromDB("user1", "user1");
		 System.out.println(cust.getFirstName());
	 }
	 
 public Customer  getUserFromDB(String name, String pwd) {
	
	 MyLogger log = new MyLogger();
	
	try {
		//dbconnection = new dbconnection();
		myConnection = new DBconnection().getConnection();
		st = myConnection.createStatement();//new dbconnection().getConnection()
		sql = "select username, passw, first_name, last_name, c.customer  from cst_user as u inner join customer as c on c.customer=u.customer where username like '" + name + "' and passw like '"+md5(pwd)+"'" ;
		QueryResult = st.executeQuery(sql);
		
		while(QueryResult.next()) {
			customer = new Customer();
			customer.setFirstName(QueryResult.getString("first_name"));
			customer.setLastName(QueryResult.getString("last_name"));
			customer.setUsername(QueryResult.getString("username"));
			customer.setPassword(QueryResult.getString("passw"));
			customer.setCustomerId(Integer.parseInt(QueryResult.getString("customer")));
            record_cnt++;
		}
        myConnection.close();
    } catch(NumberFormatException ex) {
		log.Log("GetUser - parse Id", "Wrong Id");
	} catch (SQLException e) {
		log.Log("GetUser", "SQL error");
	}
	return customer;
}

String md5(String pwd){

	String hashedPassword="";
	MessageDigest md;
	try {
		md = MessageDigest.getInstance("MD5");
		md.update(pwd.getBytes());  
		byte messageDigest[] = md.digest();
		StringBuffer hexString = new StringBuffer();
		
		for (int i=0;i<messageDigest.length;i++) {
			String hex = Integer.toHexString(0xFF & messageDigest[i]); 
			if(hex.length()==1)
				hexString.append('0');
			hexString.append(hex);
		}
		hashedPassword = hexString.toString();
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	
	return hashedPassword;
}

}
