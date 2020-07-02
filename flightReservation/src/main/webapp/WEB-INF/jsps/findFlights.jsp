<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome
<form action="findFlights" method="POST">
<pre>
From: <input type="text" name="from">
To: <input type="text" name="to">
Departure Date: <input type="text" name="departureDate">
<input type="submit" name="search">
</pre>
</form>
</body>
</html>