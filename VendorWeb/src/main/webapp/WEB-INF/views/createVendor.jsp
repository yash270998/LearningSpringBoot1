<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="saveVendor" method="POST">
<pre>
ID : <input type="text" name="id">
Code : <input type="text" name="code">
Name : <input type="text" name="name">
Type : <select name="type"><option>Regular</option>
				<option>Contract</option>
		</select>
Email: <input type="text" name="email">
Phone: <input type="text" name="phone">
Address: <input type="text" name="address">
<input type="submit" value="Save">
</pre>
</form>
${msg}
<a href="displayVendor">View All</a>
</body>
</html>