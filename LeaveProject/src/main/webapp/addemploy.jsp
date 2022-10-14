<%@page import="com.Training.LeaveProject.Employ"%>
<%@page import="com.Training.LeaveProject.EmployDAO"%>
<%@page import="java.sql.Date"%>
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
	Employ employ=new Employ();
	employ.setEmpId(Integer.parseInt(request.getParameter("empId")));
	employ.setEmpName(request.getParameter("empname"));
	employ.setEmpEmail(request.getParameter("empemail"));
	employ.setEmpMobile(request.getParameter("empMobile"));
	Date empdoj= Date.valueOf(request.getParameter("empdoj"));
	employ.setEmpDoj(empdoj);
	employ.setEmpDept(request.getParameter("empDept"));
	employ.setMgrId(Integer.parseInt(request.getParameter("mgrId")));
	employ.setLeaveAvail(Integer.parseInt(request.getParameter("leaveAvail")));
	EmployDAO dao=new EmployDAO();
	out.println(dao.addEmploy(employ));
	%>



</body>
</html>