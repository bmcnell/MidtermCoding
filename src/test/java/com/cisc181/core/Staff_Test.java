package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;
import com.cisc181.exception.PersonException;

public class Staff_Test {
	private Date dobOrHire;
	private ArrayList<Staff> staffMembers;
	
	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() {
		assertEquals(1,1);
	}	
	
	@Test
	public void StaffSalary() {
		
		
		double salary = 180;
		String FirstName = "John ";
		double total = 0;
		for (int s = 0; s < 5; s++) {
			staffMembers.add(s, new Staff(FirstName, "Robert", "Smith",
				dobOrHire, "1600 Pennsylvania Ave", "(888)-888-8888", "email@email.com",
				"MWF", 2, salary, dobOrHire, eTitle.MR));
			total+=salary;
			salary *= 10;
			FirstName+="I";
			System.out.println(FirstName + ", " + salary);
		}
		double average = total/5;
		assertEquals(0.0, average, 399996);
	}

	@Test(expected=PersonException.class)
	public void InvalidDOB() throws PersonException, Exception{

	    Calendar currentDate = Calendar.getInstance();
	    @SuppressWarnings("deprecation")
		Calendar DOB = new Calendar.set(85, 12, 3);
	    int age = currentDate.get(Calendar.YEAR) - ((Calendar) DOB).get(Calendar.YEAR); 

		try{
			new Staff("John", "Robert", "Smith",
					dobOrHire, "1600 Pennsylvania Ave", "(888)-888-8888", "email@email.com",
					"MWF", 2, 180, dobOrHire, eTitle.MR);
		} catch (PersonException e) {
			throw new PersonException("Please make sure you entered your date of birth correctly,"
					+ " or ask yourself why you are trying to work past the age of 100.");
		}
	}
	
	@Test(expected = PersonException.class)
	public void InvalidPhone() throws PersonException{
		try{
			new Staff("John", "Robert", "Smith",
					dobOrHire, "1600 Pennsylvania Ave", "8888888888", "email@email.com",
					"MWF", 2, 180, dobOrHire, eTitle.MR);
		} catch (PersonException e) {
			throw new PersonException("Please enter your phone number in the correct format.");
		}
	}
}
