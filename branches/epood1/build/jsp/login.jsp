<html>
<body bgcolor="white">
<form action='c?mode=products' method=POST>
<table>
<tr><td>kasutajanimi:</td><td><input type='text' name='kasutajanimi' value=''></td></tr>
<tr><td>parool:</td><td><input type='password' name='parool' value=''></td></tr>
<tr><td></td><td><input type='submit' value='login'></td></tr>
</table>
</form>
user1/user1<br/>
<%if  ( request.getParameter("guest") == null ){ %>
	<a href="c?mode=products&guest=1">login as guest</a>
	<%} %>
</body>
</html>
