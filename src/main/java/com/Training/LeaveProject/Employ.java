package com.Training.LeaveProject;

import java.sql.Date;

public class Employ {
	private int empId;
	private String empName;
	private String empEmail;
	private String empMobile;
	private Date empDoj;
	private String empDept;
	private int mgrId;
	private int leaveAvail;
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobile=" + empMobile
				+ ", empDoj=" + empDoj + ", empDept=" + empDept + ", mgrId=" + mgrId + ", leaveAvail=" + leaveAvail
				+ "]";
	}
	public Employ(int empId, String empName, String empEmail, String empMobile, Date empDoj, String empDept, int mgrId,
			int leaveAvail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empMobile = empMobile;
		this.empDoj = empDoj;
		this.empDept = empDept;
		this.mgrId = mgrId;
		this.leaveAvail = leaveAvail;
	}
	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public int getLeaveAvail() {
		return leaveAvail;
	}
	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}
	
	
}
