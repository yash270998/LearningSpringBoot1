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
Complete Reservation
Airline: ${flight.operatingAirlines}<br>
Dep City: ${flight.departureCity}<br>
Arr City: ${flight.arrivalCity}<br>
<form action="completeReservation" method="POST">
<pre>
<h3>Passenger Details:</h3>
First Name: <input type="text" name="passengerFirstName">
Last Name: <input type="text" name="passengerLastName">
Email: <input type="text" name="passengerEmail">
Phone: <input type="text" name="passengerPhone">
<h3>Card Details</h3>
Name on the Card: <input type="text" name="nameOnTheCard">
Card No: <input type="text" name="cardNumber">
Expiry Date: <input type="text" name="expirationDate">
CVV Code: <input type="text" name="securityCode">
<input type="hidden" name="flightId" value="${flight.id}">
<input type="submit" value="Confirm">
</pre>
</form>
</body>
</html>