<%@page import="org.glassfish.jersey.internal.inject.ParamConverters.TypeValueOf"%>
<%@page import="com.Training.LeaveProject.LeaveStatus"%>
<%@page import="com.Training.LeaveProject.LeaveDetails"%>
<%@page import="com.Training.LeaveProject.LeaveDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
  }
 .bn62 {
  color:white;
  background-color: #A9A9A9;
  border-radius: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 3em;
  width: 8em;
  font-size: large;
  font-weight: 600;
  margin-top: 5em;
}
#aa{
background-color:green;
}
#ab{
background-color:red;
}

header h1 {
  font-size: 50px;
  font-weight: 600;
  background-image: linear-gradient(to left, #808080, #DCDCDC);
  color: transparent;
  background-clip: text;
  -webkit-background-clip: text;
  background-color: black;
}</style>
<body>
<Center>

	<header>
        <h1>All Leaves</h1>
    </header>   
</Center>
<table id="customers">
		<tr>
			<th>Leave ID</th>
			<th>No Of Days</th>
			<th>Manager comment</th>
			<th>Emp ID</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Leave Type</th>
			<th>Leave Status</th>
			<th>Leave Reson</th>
		</tr>

	<%
		LeaveDAO dao=new LeaveDAO();
		LeaveDetails [] Leavesarry=dao.ShowLeaves();
		for(LeaveDetails e : Leavesarry) {
	%>
		<tr>
			<td> <%=e.getLeaveId() %> </td>
			<td> <%=e.getNoOfDays() %> </td>
			<td> <%=e.getManagerComments() %>  </td>
			<td> <%=e.getEmpId() %> </td>
			<td> <%=e.getLeaveStartDate() %> </td>
			<td> <%=e.getLeaveEndDate() %> </td>
			<td ><%=e.getLeaveType()%></td>
					
					
			<% if(e.getLeaveStatus().equals(LeaveStatus.APPROVED)){
				
				%>
				<td id="aa"> <%=e.getLeaveStatus()%> </td>
		<%	}else{
				%>
				<td id="ab"> <%=e.getLeaveStatus()%> </td>
				
				
				<%} %>
			<td> <%=e.getLeaveReason()%> </td>
		</tr>
	<%
		}
	%>
	</table>
	</center>
	<a href=HomePage.html class="bn62">
  Back
</a>
</body>
</html>