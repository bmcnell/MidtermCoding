package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cisc181.exception.PersonException;

/*
 * comment
 */
public abstract class Person implements java.io.Serializable {

	private Date DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String PhoneNbr;
	private String email_address;
	public int age;
	
	public String getFirstName() {
		return FirstName;
	}

	public Person setFirstName(String FirstName) {
		FirstName = FirstName;
		return this;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public Person setMiddleName(String MiddleName) {
		MiddleName = MiddleName;
		return this;
	}

	public String getLastName() {
		return LastName;
	}

	public Person setLastName(String LastName) {
		LastName = LastName;
		return this;
	}

	public Date getDOB() {
		return DOB;
	}

	@SuppressWarnings("deprecation")
	public Date setDOB(Date DOB) throws PersonException {
		Date today = new Date();
		if ((today.getYear() - DOB.getYear()) > 100) {
			throw new PersonException("Please make sure you entered your date of birth correctly,"
					+ " or ask yourself why you are trying to work past the age of 100.");
		}else {
			return this.DOB = DOB;
		}
	}

	public Person setAddress(String newAddress) {
		address = newAddress;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Person setPhoneNbr(String PhoneNbr) throws PersonException {

		this.PhoneNbr = PhoneNbr;
		String regex = "^\\({1}([0-9]{3})\\){1}-{1}([0-9]{3})-{1}([0-9]{4})$";
		boolean b = Pattern.matches(regex, PhoneNbr);
		
		if (!b) {
			throw new PersonException("Please enter your phone number in the correct format.");
		} 
		return this;
	}
	
	public String getPhoneNbr() {
		return PhoneNbr;
	}

	public void setEmail(String newEmail) {
		email_address = newEmail;
	}

	public String getEmail() {
		return email_address;
	}

	/*
	 * Constructors No Arg Constructor
	 */
	public Person() {

	}

	/*
	 * Constructors Constructor with arguments
	 */

	public Person(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email) throws PersonException
	{
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.setDOB(DOB);
		this.address = Address;
		this.setPhoneNbr(PhoneNbr);
		this.email_address = Email;
		
	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' '
				+ this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() throws PersonException {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
			if (age > 100) {
				throw new PersonException("Please make sure you entered your date of birth correctly,"
					+ " or ask yourself why you are trying to work past the age of 100.");
			}
		}

		System.out.println("age is " + age);

		return age;
		
	}
}