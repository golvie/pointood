<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>

<h1>Hello, world !
<% if(session.getAttribute( "userName" )!=null) 
		out.print("  and wellcome "+session.getAttribute( "userName" )); %></h1>
		
<%  if(session.getAttribute( "userName" )!=null) {%>
<form method=POST ACTION='./login'>
<INPUT TYPE=hidden NAME=logout>
<input TYPE=SUBMIT value='Logout'>
</form>

<h3><a href="./FrontController">go to Front Controller</a></h3>
<%	} else { %>
<form method=POST ACTION='./login'>
<table><tr>
<td>username</td> <td><INPUT TYPE=TEXT NAME=username SIZE=20></td></tr><tr>
<td>password</td> <td> <INPUT TYPE=password NAME=password SIZE=20></td></tr><tr>
<td><input TYPE=SUBMIT value='Login'></td></tr>
</table>
</form>
<%	}%>
</body>
</html>