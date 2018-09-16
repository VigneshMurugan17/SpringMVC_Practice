<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://www.springframework.org/tags/form" prefix = "springForm" %>
<%@ page import = "com.vignesh.controller.BookingSlotController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slot Booking Success Page</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<body>
<center>
	<h2>CA Enablement  Assessments</h2><hr>

<h3>  Booking Successfully Done !!</h3><br/>
<h3><strong>Booking Number :<%=BookingSlotController.id%></strong><br></h3><br>
<h3><a href="show">Confirm Another Booking</a><br/></h3>
<h3><a href="showDetails">Show Booking Details</a></h3>
</center>
</body>
</html>