package com.epood.dao ;

import java.sql.* ;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import org.apache.commons.codec.binary.Hex;

public class UserDB {

	 String sql = "" ;
     dbconnection dbconnection ;
	 java.sql.Connection myConnection ;
	 ResultSet QueryResult ;
	 Statement st ;
	 int record_cnt = 0;


 public String  getUserFromDB(String name, String pwd) {
	String out_name = "";
	try {
		//dbconnection = new dbconnection();
		myConnection = new dbconnection().getConnection();
		st = myConnection.createStatement();//new dbconnection().getConnection()
		sql = "select username, passw, first_name, last_name  from cst_user as u inner join customer as c on c.customer=u.customer where username like '" + name + "' and passw like '"+md5(pwd)+"'" ;
		QueryResult = st.executeQuery(sql);
		
		while(QueryResult.next()) {
			out_name = QueryResult.getString("first_name")+" "+QueryResult.getString("last_name");
            record_cnt =  record_cnt + 1;
		}
        myConnection.close();
		if (record_cnt < 0) 
			out_name="";
    } catch(Exception ex) {
		ex.printStackTrace();
	}
	return out_name;
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
