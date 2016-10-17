package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.exception.PersonException;

public class Student_Test {

	//creating arraylists that will be added to later
	static ArrayList<Course> threeCourses = new ArrayList<Course>();
	static ArrayList<Semester> twoSemesters = new ArrayList<Semester>();
	static ArrayList<Student> tenStudents = new ArrayList<Student>();
	static ArrayList<Section> sixSections = new ArrayList<Section>();
	
	@BeforeClass
	public static void setup() throws PersonException, ParseException {
		DateFormat date = new SimpleDateFormat("YYYY-MM-DD");
		
		//create three new courses
		Course biology = new Course("BISC104");
		Course spanish = new Course("SPAN107");
		Course statistics = new Course("STAT200");
		threeCourses.add(biology);
		threeCourses.add(spanish);
		threeCourses.add(statistics);
		
		//create two new semesters
		Semester fall2016 = new Semester(date.parse("2016-08-30"),date.parse("2016-12-09"));
		Semester spring2017 = new Semester(date.parse("2017-02-06"),date.parse("2017-05-16"));
		twoSemesters.add(fall2016);
		twoSemesters.add(spring2017);
		
		//add two Sections for each Course & Semester (total of six Sections).
		//add them to an ArrayList of Section
		int c = 0;
		for (Course course : threeCourses) {
			for (Semester semester : twoSemesters) {
				sixSections.add(new Section(c++, semester, course, course.getGradePoints()));
			}
		}
		
		// enrolling list of 10 new students, that all live at the white house. 
		//and were born on January 1, 1990
		@SuppressWarnings("deprecation")
		Date birthday = new Date(1990, Calendar.JANUARY, 01);
		tenStudents.add(new Student("John", "Robert", "Johnson", birthday, 
					eMajor.BUSINESS, "1600 Pennsylvania Ave", "(000) 000-0000", "s0@email.com"));
		tenStudents.add(new Student("Robert", "John", "Roberts", birthday, 
					eMajor.COMPSI, "1600 Pennsylvania Ave", "(111) 111-1111", "s1@email.com"));
		tenStudents.add(new Student("Bonnie", "Ann", "McNellis", birthday, 
					eMajor.CHEM, "1600 Pennsylvania Ave", "(222) 222-2222", "s2@email.com"));
		tenStudents.add(new Student("Gisselle", "Patricia", "Garcia", birthday, 
					eMajor.PHYSICS, "1600 Pennsylvania Ave", "(333) 333-3333", "s3@email.com"));
		tenStudents.add(new Student("Megan", "Elizabeth", "Tanabe", birthday, 
					eMajor.NURSING, "1600 Pennsylvania Ave", "(444) 444-4444", "s4@email.com"));
		tenStudents.add(new Student("Jordan", "Thomas", "Kavanaugh", birthday, 
					eMajor.BUSINESS, "1600 Pennsylvania Ave", "(555) 555-5555", "s5@email.com"));
		tenStudents.add(new Student("Zuzie", "May", "Q", birthday, 
					eMajor.COMPSI, "1600 Pennsylvania Ave", "(676) 676-6766", "s6@email.com"));
		tenStudents.add(new Student("James", "Something", "Bond", birthday, 
					eMajor.CHEM, "1600 Pennsylvania Ave", "(777) 007-7777", "s7@email.com"));
		tenStudents.add(new Student("Thomas", "The", "Tank", birthday, 
					eMajor.PHYSICS, "1600 Pennsylvania Ave", "(888) 888-8888", "s8@email.com"));
		tenStudents.add(new Student("Hayley", "Marie", "Richards", birthday,
					eMajor.NURSING, "1600 Pennsylvania Ave", "(999) 999-9999", "s9@email.com"));
		
	}

	@Test
	public void testTest() {
		assertEquals(1, 1);
	}
	
	//change major of one of enrolled students
	//success
	@Test
	public void testMajor() {
		assertEquals(tenStudents.get(1).getMajor(), eMajor.COMPSI);
		tenStudents.get(1).setMajor(eMajor.BUSINESS);
		assertEquals(tenStudents.get(1).getMajor(), eMajor.BUSINESS);
	}
	
}