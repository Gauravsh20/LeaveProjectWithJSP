package com.Training.LeaveProject;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import org.junit.Assert;
import org.junit.Test;

public class EmployTest1 {
	String date_string = "2007-25-06";
	@Test
	public void test() {
		int empId=100;
		String empName = "gaurav";
		String empEmail ="s.gaurav@gmail.com";
		String empMobile = "245678";
		String empDoj="2007-25-06";
		String empDept = "Software";
		int mgrId = 123;
		
		
		
		Employ employ=new Employ();
		employ.setEmpId(empId);
		int value = employ.getEmpId();
	    Assert.assertTrue("Error", value==empId);
	    
	    
	    employ.setEmpName(empName);
	    String value2=employ.getEmpName();
	    Assert.assertEquals(value2,empName);
	    
	    employ.setEmpEmail(empEmail);
	    String value3=employ.getEmpEmail();
	    Assert.assertEquals(value3,empEmail);
	    
	    employ.setEmpMobile(empMobile);
	    Assert.assertEquals(employ.getEmpMobile(), empMobile);
	 
	    employ.setEmpDoj(Date.valueOf("2022-08-18"));
	    Assert.assertEquals(Date.valueOf("2022-08-18"),employ.getEmpDoj());
	    
	    employ.setEmpDept(empDept);
	    Assert.assertEquals(empDept, employ.getEmpDept());
	    
	    employ.setMgrId(mgrId);
	    Assert.assertEquals(mgrId, employ.getMgrId());
	    
	    employ.setLeaveAvail(10);
	    assertEquals(10, employ.getLeaveAvail());
		
	}
	@Test
	public void testToString() {
		Employ employ= new Employ(1, "Gaurav", "gaura@gmail.com", "6942069420", Date.valueOf("2022-08-18"), "Java", 1000, 10);
		
		String result =  "Employ [empId=" + 1 + ", empName=" + "Gaurav" + ", empEmail=" + "gaura@gmail.com" + ", empMobile=" + "6942069420"
				+ ", empDoj=" +  Date.valueOf("2022-08-18") + ", empDept=" + "Java" + ", mgrId=" + 1000 + ", leaveAvail=" + 10
				+ "]";
		assertEquals(result, employ.toString());
}

	@Test
	public void testConstructor(){
		Employ employ1 = new Employ();
		assertNotNull(employ1);
		
		Employ employ2 = new Employ(1, "Javed Khan", "javed@khan.com", "6942069420", Date.valueOf("2022-08-18"), "Java", 1000, 10);
		assertEquals(1, employ2.getEmpId());
		assertEquals("Javed Khan", employ2.getEmpName());
		assertEquals("javed@khan.com", employ2.getEmpEmail());
		assertEquals("6942069420", employ2.getEmpMobile());
		assertEquals(Date.valueOf("2022-08-18"), employ2.getEmpDoj());
		assertEquals("Java", employ2.getEmpDept());
		assertEquals(1000, employ2.getMgrId());
		assertEquals(10, employ2.getLeaveAvail()); 
	}
	
	

}