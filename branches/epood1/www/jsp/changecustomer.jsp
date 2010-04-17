<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.domain.Customer" %> 
<%@ page import="com.epood.log.MyLogger"  %> 
<%@ page import="java.util.ArrayList"  %> 
<jsp:useBean id="CustomerDAO" scope="page" class="com.epood.dao.CustomerDao" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change customer</title>
</head>
<body>
<script>
function salvesta() {
document.forms[0].mida_teha.value='salvestada' ;
document.forms[0].submit(); 
}

function muuda_firstname() {
document.forms[0].firstname.value='First Name ...' ;
}
</script>
<b> JSP/JavaBean example .  OO bean. DAO</b><br><hr>
<a href="FrontController">back to the customers list</a>
<form action='FrontController?mode=change_customer' method=POST>
<input type='hidden' name='mida_teha' value='<%=request.getParameter("mida_teha")%>'>
<input type='hidden' name='customer' value='<%=request.getParameter("customer")%>'>
Chosen customer: <br>

<%
	int customer = Integer.valueOf(request.getParameter("customer")).intValue();
      int customer_code;
      String first_name;
      String last_name;
      com.epood.model.domain.Customer myCustomer;
   

if (request.getParameter("mida_teha") != null) {

	try {
		myCustomer = CustomerDAO.getCustomerFromDB(customer);
		myCustomer.setFirstName(request.getParameter("firstname"));
		myCustomer.setLastName(request.getParameter("lastname"));
      	CustomerDAO.updateCustomerToDB(myCustomer);
    } catch (Exception ex) {
       out.println("ERROR!:" + ex.getMessage());
       MyLogger MyLogger = new MyLogger();
       MyLogger.Log("JSP/changecustomer/customer salvestamise blokk:",ex.getMessage());
    }

}

out.println("<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0><tr><td><table width=100% border=0 cellpadding=2 cellspacing=1>");
            
      if ((myCustomer = CustomerDAO.getCustomerFromDB(customer)) != null){  
    	  customer_code = myCustomer.getCustomerId() ;
    	  first_name = myCustomer.getFirstName();
    	  last_name = myCustomer.getLastName();                   
		  out.println("<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>kood</td><td>&nbsp;" + customer_code + "&nbsp;</TD></tr>");
		  out.println("<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>First name</td><td>&nbsp;<input type='text' value='" + first_name + "' name='firstname'>&nbsp;</TD></tr>");
		  out.println("<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>Last name</td><td>&nbsp;<input type='text' value='" + last_name + "' name='lastname'>&nbsp;</TD></tr>");
       }

out.println("</table></td></tr></table>");
%>

<input type="button" value="change firstname" onClick="muuda_firstname()">
<input type="button" value="salvesta" onClick="salvesta()">

<% 
out.println("<hr><font color='red'> edasi antud parameeter:</font> customer = <b> ");

out.println(request.getParameter("customer"));
	        out.println("</b><br>");

out.println("<font color='red'> edasi antud parameeter:</font> mida_teha = <b> ");

out.println(request.getParameter("mida_teha"));
	        out.println("</b><br>");



%>
</form>
</body>
</html>