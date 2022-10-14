<%@page import="com.Training.LeaveProject.Employ"%>
<%@page import="com.Training.LeaveProject.EmployDAO"%>
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
<Center>
<header>
        <h1>Employ Search</h1>
    </header>  
</Center>
<table border="3" id="customers">
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
		int empno = Integer.parseInt(request.getParameter("empno"));
		EmployDAO dao=new EmployDAO();
		Employ employee = dao.searchEmploy(empno);
		if (employee!=null) {
			%>	
		<tr>
			<td> <%=employee.getEmpId() %> </td>
			<td> <%=employee.getEmpName() %></td>
			<td> <%=employee.getEmpEmail() %>  </td>
			<td> <%=employee.getEmpMobile() %> </td>
			<td> <%=employee.getEmpDoj() %> </td>
			<td> <%=employee.getEmpDept() %> </td>
			<td> <%=employee.getMgrId() %> </td>
			<td> <%=employee.getLeaveAvail() %> </td>
		</tr>
	<%	}
	%>
	</table>
	<a href=HomePage.html class="bn62">
  Home Page
</a>
</body>
</html>



	
	