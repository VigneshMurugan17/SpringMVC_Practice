<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Page</title>
<style>
.error {
	color : #ff0000;
	font-syle : italic;
	font-weight :  bold;
}
</style>
</head>
<body>
	<center>
		<springForm:form method = "POST" commandName = "bookingSlotVO" action = "confirm">
			<h2>CA Enablement Assessments</h2>
			<hr>
			<h3>Book a Slot</h3>
			<hr>
			Language : <a href="?locale=en">English</a> <a href="?locale=fr">French</a>
			<table>
				<tr>
					<td><Strong><spring:message code="label.Id"/></Strong></td>
					<td><springForm:input path="employeeId" class="form-text" /></td>
					<td><springForm:errors path="employeeId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Employee Name:</td>
					<td><springForm:input path="employeeName" class="form-text" /></td>
					<td><springForm:errors path="employeeName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><springForm:input path="email" class="form-text" /></td>
					<td><springForm:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><springForm:input path="phone" class="form-text" /></td>
					<td><springForm:errors path="phone" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Account Name:</td>
					<td><springForm:input path="accountName" class="form-text" /></td>
					<td><springForm:errors path="accountName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Assessment Name :</td>
					<td><springForm:select path="assessmentName">
							<springForm:option value="" label="--- Select ---" />
							<springForm:options items="${assessmentList}" />
						</springForm:select></td>
					<td><springForm:errors path="assessmentName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Level:</td>
					<td><springForm:radiobuttons path="level" items="${levelList}" />
					</td>
					<td><springForm:errors path="level" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Date Of Assessment(dd-MMM-yyyy):</td>
					<td><springForm:input path="dateOfAssessment"
							placeholder="dd-MMM-yyyy" /></td>
					<td><springForm:errors path="dateOfAssessment"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Time Slot :</td>
					<td><springForm:select path="slot">
							<springForm:option value="" label="--- Select ---" />
							<springForm:options items="${slotList}" />
						</springForm:select></td>
					<td><springForm:errors path="slot" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Confirm Booking"></td>
				</tr>
			</table>
		</springForm:form>
		
		<h3>
			<a href="showDetails">Show Booking Details</a>
		</h3>
	</center>
</body>
</html>