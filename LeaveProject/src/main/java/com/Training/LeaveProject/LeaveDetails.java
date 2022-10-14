package com.Training.LeaveProject;

import java.util.Date;

public class LeaveDetails {

	private int leaveId;
	private int noOfDays;
	private String managerComments;
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private LeaveStatus leaveStatus;
	private LeaveType leaveType;
	private String leaveReason;
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", noOfDays=" + noOfDays + ", managerComments=" + managerComments
				+ ", empId=" + empId + ", leaveStartDate=" + leaveStartDate + ", leaveEndDate=" + leaveEndDate
				+ ", leaveStatus=" + leaveStatus + ", leaveType=" + leaveType + ", leaveReason=" + leaveReason + "]";
	}
	public LeaveDetails(int leaveId, int noOfDays, String managerComments, int empId, Date leaveStartDate,
			Date leaveEndDate, LeaveStatus leaveStatus, LeaveType leaveType, String leaveReason) {
		super();
		this.leaveId = leaveId;
		this.noOfDays = noOfDays;
		this.managerComments = managerComments;
		this.empId = empId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveStatus = leaveStatus;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
	}
	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
}
