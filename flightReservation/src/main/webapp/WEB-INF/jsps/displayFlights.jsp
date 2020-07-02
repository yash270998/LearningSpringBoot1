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
<h3>Flights: </h3>
<table>
<tr>
	<th>Airlines</th>
	<th>Dep City</th>
	<th>Arr City</th>
	<th>Dep Time</th>
</tr>
<c:forEach items="${flights}" var="flight">
<tr>
	<td>${flight.operatingAirlines}</td>
	<td>${flight.departureCity}</td>
	<td>${flight.arrivalCity}</td>
	<td>${flight.estimatedDepartureTime}</td>
	<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>