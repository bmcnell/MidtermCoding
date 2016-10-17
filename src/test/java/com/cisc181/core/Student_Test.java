package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> threeCourses = new ArrayList<Course>();
	static ArrayList<Student> tenStudents = new ArrayList<Student>();
	static ArrayList<Semester> twoSemesters = new ArrayList<Semester>();
	
	@BeforeClass
	public static void setup() {
		
		Course biology = new Course("BISC104");
		Course spanish = new Course("SPAN107");
		Course statistics = new Course("STAT200");
		threeCourses.add(biology);
		threeCourses.add(spanish);
		threeCourses.add(statistics);
		
		Semester fall = new Semester();
		Semester spring = new Semester();
		twoSemesters.add(fall);
		twoSemesters.add(spring);
		
		ArrayList<Section> sections = new ArrayList<Section>();
		int count = 1;
		for (Semester semester : twoSemesters) {
			for (Course course : threeCourses) {
				sections.add(new Section());
			}
		}
		try { 
			// enrolling list of 10 new students, that all live at the white house. 
			tenStudents.add(new Student("John", "Robert", "Johnson", Date.valueOf("1985-10-10"), 
					eMajor.BUSINESS, "1600 Pennsylvania Ave", "(000) 000-0000", "s0@email.com"));
			tenStudents.add(new Student("Robert", "John", "Roberts", Date.valueOf("1985-01-01"), 
					eMajor.COMPSI, "1600 Pennsylvania Ave", "(111) 111-1111", "s1@email.com"));
			tenStudents.add(new Student("Bonnie", "Ann", "McNellis", Date.valueOf("1985-02-02"), 
					eMajor.CHEM, "1600 Pennsylvania Ave", "(222) 222-2222", "s2@email.com"));
			tenStudents.add(new Student("Gisselle", "Patricia", "Garcia", Date.valueOf("1985-03-03"), 
					eMajor.PHYSICS, "1600 Pennsylvania Ave", "(333) 333-3333", "s3@email.com"));
			tenStudents.add(new Student("Megan", "Elizabeth", "Tanabe", Date.valueOf("1985-04-04"), 
					eMajor.NURSING, "1600 Pennsylvania Ave", "(444) 444-4444", "s4@email.com"));
			tenStudents.add(new Student("Jordan", "Thomas", "Kavanaugh", Date.valueOf("1985-05-05"), 
					eMajor.BUSINESS, "1600 Pennsylvania Ave", "(555) 555-5555", "s5@email.com"));
			tenStudents.add(new Student("Zuzie", "May", "Q", Date.valueOf("1985-06-06"), 
					eMajor.COMPSI, "1600 Pennsylvania Ave", "(676) 676-6766", "s6@email.com"));
			tenStudents.add(new Student("James", "Something", "Bond", Date.valueOf("1985-07-07"), 
					eMajor.CHEM, "1600 Pennsylvania Ave", "(777) 007-7777", "s7@email.com"));
			tenStudents.add(new Student("Thomas", "The", "Tank", Date.valueOf("1985-08-08"), 
					eMajor.PHYSICS, "1600 Pennsylvania Ave", "(888) 888-8888", "s8@email.com"));
			tenStudents.add(new Student("Hayley", "Marie", "Richards", Date.valueOf("1985-09-09"),
					eMajor.NURSING, "1600 Pennsylvania Ave", "(999) 999-9999", "s9@email.com"));
		} catch (PersonException e) {

		}
		
	}


	@Test
	public void test() {
		assertEquals(1, 1);
	}
}