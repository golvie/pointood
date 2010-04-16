<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.data.customer.Customer"  %> 
<%@ page import="java.util.ArrayList"  %> 
<jsp:useBean id="CustomerDAO" scope="page" class="com.epood.dao.CustomerDao" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp" /><br>
<b> Customers example for epood . demonstrate DAO</b><br>
<b><a href="index.jsp">back</a></b><br/><hr>
Customers list: <br>

<% 
      String customer_kood = "" ;
      String first_name = "" ;
      String last_name = "" ;
      ArrayList<Customer> customerList =  CustomerDAO.getCustomersFromDB();
      
      out.println("<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0><tr><td><table width=100% border=0 cellpadding=2 cellspacing=1>");
      out.println("<tr bgcolor='#cccccc'><td><STRONG> kood&nbsp;</td><td><STRONG>First name&nbsp;</td><td><STRONG>Last name&nbsp;</td><td>......</td></tr>");

  try {
      for (int n = 0; n < customerList.size()  ; n++) {    
    	  customer_kood = Integer.toString(customerList.get(n).getCustomerId());
    	  first_name = customerList.get(n).getFirstName();
    	  last_name = customerList.get(n).getLastName();
          out.println("<TR BGCOLOR='#FFFFFF' ><TD  nowrap>");
          out.println("&nbsp;"+ customer_kood + "&nbsp;</TD><TD>"+ first_name +  "&nbsp;</TD><TD>"+ last_name + "&nbsp;");
          out.println("</TD><TD align='top' nowrap><a HREF='FrontController?mode=change_customer&customer=" + customer_kood  + "' TARGET='_self'><b><u>muuda andmeid</u><b></a> <a HREF='FrontController?mode=XML&customer=" + customer_kood  + "' TARGET='_blank'><b><u>XML</u><b></a></TD></TR>");               
      }
  } catch(Exception ex) { 
		out.println("Mingi viga");
		if (customerList == null) {
			out.println("Massiivi ei saanud katte");
		}
	}
         
  out.println("</table></td></tr></table>");
  out.println("</form>");
 %>

</body>
</html>