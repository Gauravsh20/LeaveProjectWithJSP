package com.Training.LeaveProject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
	Connection connection;
	PreparedStatement pst;
	
//Search Leave's	
	public LeaveDetails searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelperLMR.getConnection();
		String cmd = "select * from leave_history where LEAVE_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveId);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leaveDetails = null;
		if (rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveDetails.setEmpId(rs.getInt("EMP_ID"));
			leaveDetails.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveDetails.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveDetails.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveDetails.setLeaveReason(rs.getString("LEAVE_REASON"));
			
		}
		return leaveDetails;
	 }
	
// Approved the Leave
	public String approveDeny(int leaveId, int mgrId, String managerComments, String status) throws ClassNotFoundException, SQLException {
		LeaveDetails ld = searchByLeaveId(leaveId);
		connection = ConnectionHelperLMR.getConnection();
		Employ emp = new EmployDAO().searchEmploy(ld.getEmpId());
		LeaveDetails leaveDetails = searchByLeaveId(leaveId);
		int empId=leaveDetails.getEmpId();
		int noOfDays = leaveDetails.getNoOfDays();
		if (mgrId==emp.getMgrId()) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update leave_history SET LEAVE_STATUS='APPROVED',"
						+ "LEAVE_MNGR_COMMENTS=? where LEAVE_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setString(1, managerComments);
				pst.setInt(2, leaveId);
				pst.executeUpdate();
				return "Leave Approved...";
			} else {
				String cmd = "Update leave_history SET LEAVE_STATUS='DENIED', "
						+ "LEAVE_MNGR_COMMENTS=? where LEAVE_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setString(1, managerComments);
				pst.setInt(2, leaveId);
				pst.executeUpdate();
				cmd = "UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BAL=EMP_AVAIL_LEAVE_BAL+? "
						+ " WHERE EMP_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, noOfDays);
				pst.setInt(2, empId);
				pst.executeUpdate();
				return "Leave not Approved...";
			}
		} else {
			return "You Are unauthorized Manager...";
		}
	}
	
	
	//Apply leave
	
public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
		
		 long ms = leaveDetails.getLeaveEndDate().getTime() - leaveDetails.getLeaveStartDate().getTime();
		    long m = ms / (1000 * 24 * 60 * 60);
		    int days = (int) m;
		    days = days + 1;
		    leaveDetails.setLeaveType(LeaveType.EL);
		    leaveDetails.setLeaveStatus(LeaveStatus.PENDING);
		    Employ employee = new EmployDAO().searchEmploy(leaveDetails.getEmpId());
		    int leaveBalance = employee.getLeaveAvail();//total leave avilable's of employ. 
		    //chheck the start date and end date.
		    if (days < 0) {
		    	return "Leave-Start Date Cannot be Greater than leave-End Date...";
		    } else if (leaveBalance-days < 0) {
		    	
		    	
		    	//check diffrence the avilable and required leave
		    	
		    	return "Insufficient Leave Balance...";
		    } else {
		    	
		    	int diff = leaveBalance-days;
		    	leaveDetails.setNoOfDays(days);
		    	connection = ConnectionHelperLMR.getConnection();
		    	String cmd = "Insert into LEAVE_HISTORY(Emp_ID,Leave_Start_Date, "
		    			+ "Leave_End_Date,Leave_Type,Leave_Status,Leave_Reason,LEAVE_NO_OF_DAYS) "
		    			+ "VALUES(?,?,?,?,?,?,?)";
		    	pst = connection.prepareStatement(cmd);
		    	pst.setInt(1, leaveDetails.getEmpId());
		    	pst.setDate(2, (Date) leaveDetails.getLeaveStartDate());
		    	pst.setDate(3,  (Date) leaveDetails.getLeaveEndDate());
		    	pst.setString(4, leaveDetails.getLeaveType().toString());
		    	pst.setString(5, leaveDetails.getLeaveStatus().toString());
		    	pst.setString(6, leaveDetails.getLeaveReason());
		    	pst.setInt(7, leaveDetails.getNoOfDays());
		    	pst.executeUpdate();
		    	cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL=? WHERE EMP_ID=?";
		    	pst = connection.prepareStatement(cmd);
		    	pst.setInt(1, diff);
		    	pst.setInt(2, leaveDetails.getEmpId());
		    	pst.executeUpdate();
		    	return "Leave Applied Successfully...";
		    }
	}

//show All Leaves

public LeaveDetails[] ShowLeaves() throws ClassNotFoundException, SQLException {
	connection=ConnectionHelperLMR.getConnection();
	String cmd="select * from LEAVE_HISTORY";
	pst=connection.prepareStatement(cmd);
	List<LeaveDetails>leaveslist=new ArrayList();
	ResultSet rs=pst.executeQuery();
	LeaveDetails leaves=null;
	while(rs.next()) {
		leaves=new LeaveDetails();
		leaves.setLeaveId(rs.getInt("LEAVE_ID"));
		leaves.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
		leaves.setManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
		leaves.setEmpId(rs.getInt("EMP_ID"));
		leaves.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
		leaves.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
		leaves.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
		leaves.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
		leaves.setLeaveReason(rs.getString("LEAVE_REASON"));
		leaveslist.add(leaves);
		
	}
	
	return leaveslist.toArray(new LeaveDetails[leaveslist.size()]);
}



}
