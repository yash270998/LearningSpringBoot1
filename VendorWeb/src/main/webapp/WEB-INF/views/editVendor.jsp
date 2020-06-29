<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateVendor" method="POST">
<pre>
ID : <input type="text" name="id" value="${vendor.id}" readonly=true>
Code : <input type="text" name="code" value="${vendor.code}">
Name : <input type="text" name="name" value="${vendor.name}">
Type : <select name="type">
		<option ${vendor.type == 'Regular' ? 'selected' : ''}>Regular</option>
		<option ${vendor.type == 'Contract' ? 'selected' : ''}>Contract</option>	 
		</select>
Email : <input type="text" name="email" value="${vendor.email}">
Phone : <input type="text" name="phone" value="${vendor.phone}">
Address : <input type="text" name="address" value="${vendor.address}">
<input type="submit" value="Save">
</pre>
</form>
</body>
</html>