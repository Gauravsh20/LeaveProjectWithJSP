package com.Training.LeaveProject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmployDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	
//Search Employ 
	
	public Employ searchEmploy(int empno) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelperLMR.getConnection();
		String cmd = "select * from Employee where emp_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employ employee = null;
		if (rs.next()) {
			employee = new Employ();
			employee.setEmpId(rs.getInt("EMP_ID"));
			employee.setEmpName(rs.getString("EMP_NAME"));
			employee.setEmpEmail(rs.getString("EMP_MAIL"));
			employee.setEmpMobile(rs.getString("EMP_MOB_NO"));
			employee.setEmpDoj(rs.getDate("EMP_DT_JOIN"));
			employee.setEmpDept(rs.getString("EMP_DEPT"));
			employee.setMgrId(rs.getInt("EMP_MANAGER_ID"));
			employee.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));
		}
		return employee;
	}
	
//show All Employ	
	
	public Employ[] showEmploy() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelperLMR.getConnection();
		String cmd = "select * from Employee";
		pst = connection.prepareStatement(cmd);
		List<Employ> employList = new ArrayList();
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		while(rs.next()) {
			employ = new Employ();
			employ.setEmpId(rs.getInt("EMP_ID"));
			employ.setEmpName(rs.getString("EMP_NAME"));
			employ.setEmpEmail(rs.getString("EMP_MAIL"));
			employ.setEmpMobile(rs.getString("EMP_MOB_NO"));
			employ.setEmpDoj(rs.getDate("EMP_DT_JOIN"));
			employ.setEmpDept(rs.getString("EMP_DEPT"));
			employ.setMgrId(rs.getInt("EMP_MANAGER_ID"));
			employ.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));
			employList.add(employ);
			
		}
		return employList.toArray(new Employ[employList.size()]);
	}
	
	//Add Employ
	public String addEmploy(Employ employ) throws SQLException, ClassNotFoundException
	{
		connection=ConnectionHelperLMR.getConnection();
		String cmd="insert into EMPLOYEE (EMP_ID,EMP_NAME,EMP_MAIL ,EMP_MOB_NO,EMP_DT_JOIN,EMP_DEPT,EMP_MANAGER_ID,EMP_AVAIL_LEAVE_BAL)"+ "value(?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, employ.getEmpId());
		pst.setString(2, employ.getEmpName());
		pst.setString(3, employ.getEmpEmail());
		pst.setString(4, employ.getEmpMobile());
		pst.setDate(5,employ.getEmpDoj());
		pst.setString(6, employ.getEmpDept());
		pst.setInt(7, employ.getMgrId());
		pst.setInt(8, employ.getLeaveAvail());
		pst.executeUpdate();
		return"Employee Successfully Insert....! Thank you";
	}
// Delete Employ
	
}
