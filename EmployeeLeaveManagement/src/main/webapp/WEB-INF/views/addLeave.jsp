<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertleave" method="post">
		<fieldset>
			<legend>Add leave</legend>
			Employee Id:<input type="text" name="empid" placeholder="Enter id"><br><br>
		    Start Date:<input type="text" name="startdate"><br>
			<br> 
			End Date:<input type="text" name="enddate"><br>
			<br> 
			Leave Type:<select name="leavetype">
				<option>Earned Leave</option>
				<option>Loss Of Pay</option>
			</select><br>
			<br> Leave Reason:<select name="leavereason">
				<option>Personal</option>
				<option>Sick</option>
				<option>Ritual</option>
				<option>Out of station</option>
			</select>
			
			<button type="submit">ADD</button>
		</fieldset>
	</form>
</body>

</body>
</html>