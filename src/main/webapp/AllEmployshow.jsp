
<%@page import="com.Training.LeaveProject.EmployDAO"%>
<%@page import="com.Training.LeaveProject.Employ"%>
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
header h1 {
  font-size: 50px;
  font-weight: 600;
  background-image: linear-gradient(to left, #808080, #DCDCDC);
  color: transparent;
  background-clip: text;
  -webkit-background-clip: text;
  background-color: black;
}
</style>
<body>
<center>
<header>
        <h1>Employee List</h1>
    </header>   
<table id="customers">
		<tr>
			<th>Employ ID</th>
			<th>Employ Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Date of Join</th>
			<th>Department</th>
			<th>ManagerId</th>
			<th>Available Balance</th>
		</tr>

	<%
		EmployDAO dao=new EmployDAO();
		Employ[]employArray  = dao.showEmploy();
		for(Employ e : employArray) {
	%>
		<tr>
			<td> <%=e.getEmpId() %> </td>
			<td> <%=e.getEmpName() %> </td>
			<td> <%=e.getEmpEmail() %>  </td>
			<td> <%=e.getEmpMobile() %> </td>
			<td> <%=e.getEmpDoj() %> </td>
			<td> <%=e.getEmpDept() %> </td>
			<td> <%=e.getMgrId() %> </td>
			<td> <%=e.getLeaveAvail() %> </td>
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