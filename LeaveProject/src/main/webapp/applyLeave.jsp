<%@page import="com.Training.LeaveProject.LeaveDAO"%>
<%@page import="com.Training.LeaveProject.LeaveDetails"%>
<%@page import="java.sql.Date"%>
=
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		LeaveDetails leaveDetails=new LeaveDetails();
		leaveDetails.setEmpId(Integer.parseInt(request.getParameter("empId")));
		Date leaveStartDate = Date.valueOf(request.getParameter("leaveStartDate"));
		Date leaveEndDate = Date.valueOf(request.getParameter("leaveEndDate"));
		leaveDetails.setLeaveStartDate(leaveStartDate);
		leaveDetails.setLeaveEndDate(leaveEndDate);
		leaveDetails.setLeaveReason(request.getParameter("leaveReason"));
		
		LeaveDAO dao = new LeaveDAO();%>
		<h1><%out.println(dao.applyLeave(leaveDetails)); %></h1>
	
</body>
</html>