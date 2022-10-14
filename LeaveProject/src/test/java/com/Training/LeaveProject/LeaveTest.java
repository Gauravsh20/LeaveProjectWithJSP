package com.Training.LeaveProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;

public class LeaveTest {
	@Test
	public void testGetterAndSetter() {
		LeaveDetails leaveGetterAndSetter = new LeaveDetails();
		leaveGetterAndSetter.setLeaveId(1);
		leaveGetterAndSetter.setEmpId(1000);
		leaveGetterAndSetter.setLeaveStartDate(Date.valueOf("2022-10-10"));
		leaveGetterAndSetter.setLeaveEndDate(Date.valueOf("2022-10-11"));
		leaveGetterAndSetter.setLeaveType(LeaveType.EL);
		leaveGetterAndSetter.setLeaveStatus(LeaveStatus.APPROVED);
		leaveGetterAndSetter.setNoOfDays(2);
		leaveGetterAndSetter.setManagerComments("Go and Enjoy.");
		leaveGetterAndSetter.setLeaveReason("Aise hi");
		
		assertEquals(1, leaveGetterAndSetter.getLeaveId());
		assertEquals(1000, leaveGetterAndSetter.getEmpId());
		assertEquals(Date.valueOf("2022-10-10"), leaveGetterAndSetter.getLeaveStartDate());
		assertEquals(Date.valueOf("2022-10-11"), leaveGetterAndSetter.getLeaveEndDate());
		assertEquals(LeaveType.EL, leaveGetterAndSetter.getLeaveType());
		assertEquals(LeaveStatus.APPROVED, leaveGetterAndSetter.getLeaveStatus());
		assertEquals(2, leaveGetterAndSetter.getNoOfDays());
		assertEquals("Go and Enjoy.", leaveGetterAndSetter.getManagerComments());
		assertEquals("Aise hi", leaveGetterAndSetter.getLeaveReason());
	}
	@Test
	public void testConstructor(){
		LeaveDetails leave = new LeaveDetails();
		assertNotNull(leave);
		
		LeaveDetails leaveCons = new LeaveDetails(1, 1, "Go and Enjoy.", 1000, Date.valueOf("2022-10-10"), Date.valueOf("2022-10-11"),
				LeaveStatus.APPROVED, LeaveType.EL, "Aise hi");
		assertEquals(1, leaveCons.getLeaveId());
		assertEquals(1, leaveCons.getNoOfDays());
		assertEquals("Go and Enjoy.", leaveCons.getManagerComments());
		assertEquals(1000, leaveCons.getEmpId());
		assertEquals(Date.valueOf("2022-10-10"), leaveCons.getLeaveStartDate());
		assertEquals(Date.valueOf("2022-10-11"), leaveCons.getLeaveEndDate());
		assertEquals(LeaveStatus.APPROVED, leaveCons.getLeaveStatus());
		assertEquals(LeaveType.EL, leaveCons.getLeaveType());
		assertEquals("Aise hi", leaveCons.getLeaveReason());
	}
	@Test
	public void testToString() {
		String result = "LeaveDetails [leaveId=" + 1 + ", noOfDays=" + 1 + ", managerComments=" + "Go and Enjoy." + ", empId=" + 1000
				+ ", leaveStartDate=" + Date.valueOf("2022-10-10") + ", leaveEndDate=" + Date.valueOf("2022-10-11") + ", leaveStatus="
				+ LeaveStatus.APPROVED + ", leaveType=" + LeaveType.EL + ", leaveReason=" + "Aise hi" + "]";
		
		LeaveDetails leaveToString = new LeaveDetails(1, 1, "Go and Enjoy.", 1000, Date.valueOf("2022-10-10"), Date.valueOf("2022-10-11"),
				LeaveStatus.APPROVED, LeaveType.EL, "Aise hi");
		
		assertEquals(result, leaveToString.toString());
	}
}
