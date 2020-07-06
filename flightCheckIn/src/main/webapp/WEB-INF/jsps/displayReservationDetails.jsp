<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details:</h2>
Airlines : ${reservation.flight.operatingAirlines}<br>
Flight No : ${reservation.flight.flightNumber}<br>
departureCity : ${reservation.flight.departureCity}<br>
arrivalCity : ${reservation.flight.arrivalCity}<br>
dateOfDeparture : ${reservation.flight.dateOfDeparture}<br>
estimatedDepartureTime : ${reservation.flight.estimatedDepartureTime}<br>
<br>
<h2>Passenger Details</h2>
First Name : ${reservation.passenger.firstName}<br>
Last Name : ${reservation.passenger.lastName}<br>
Email : ${reservation.passenger.email}<br>
Phone : ${reservation.passenger.phone}<br>
<br>
<form action="completeCheckIn" method="POST">
Enter the number of bags to check in! : <input type="text" name="numberOfBags">
<input type="hidden" value="${reservation.id}" name="reservationId">
<input type="submit" value="Check iN">

</form>
</body>
</html>