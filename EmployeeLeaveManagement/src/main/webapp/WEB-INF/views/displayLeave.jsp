<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Leave Details</legend>
		<table border="1">

			<tr>
				<th>Leave Id</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Leave Type</th>
				<th>Leave Reason</th>
			</tr>
			<c:forEach var="s" items="${l}">
				<tr>
				  <td>${s.leave_id}</td>
				  <td>${s.start_on}</td>
				  <td>${s.end_on}</td>
				  <td>${s.leave_type}</td>
				  <td>${s.leave_reason}</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>


</body>
</html>