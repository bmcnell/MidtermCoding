package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class Student_Test {

	static ArrayList<Course> threeCourses = new ArrayList<Course>;
	static ArrayList<Student> tenStudents = new ArrayList<Student>();
	static ArrayList<Semester> twoSeemesters = new ArrayList<Semester>();
	
	@BeforeClass
	public static void setup() {
		
		Course biology = new Course("BISC104");
		Course spanish = new Course("SPAN107");
		Course statistics = new Course("STAT200");
		courses.add(biology);
		courses.add(spanish);
		courses.add(statistics);
		
		Semester fall = new Semester(Date.valueOf("2016-08-30"), Date.valueOf("2016-12-21"));
		Semester spring = new Semester(Date.valueOf("2017-02-6"), Date.valueOf("2017-05-26"));
		semesters.add(fall);
		semesters.add(spring);
		
		ArrayList<Section> sections = new ArrayList<Section>();
		int count = 1;
		for (Semester semester : semesters) {
			for (Course course : courses) {
				sections.add(new Section(count++, semester, course, course.getGradePoints()));
			}
		}
		try {
			students.add(new Student("Alex", "A", "Andrews", Date.valueOf("1996-08-08"), eMajor.CHEM, "123 Way Rd",
					"(302) 111-1111", "aaa@gmail.com"));
			students.add(new Student("Bob", "B", "Barnes", Date.valueOf("1996-09-09"), eMajor.CHEM, "456 Place Pl",
					"(302) 222-2222", "bbb@gmail.com"));
			students.add(new Student("Chris", "C", "Collins", Date.valueOf("1996-10-10"), eMajor.BUSINESS,
					"789 Long Rd", "(302) 333-3333", "ccc@gmail.com"));
			students.add(new Student("David", "D", "Davies", Date.valueOf("1996-11-11"), eMajor.BUSINESS,
					"1011 Court Ct", "(302) 444-4444", "ddd@gmail.com"));
			students.add(new Student("Evan", "E", "Evanson", Date.valueOf("1996-12-12"), eMajor.NURSING,
					"1213 Plaza Pl", "(302 555-5555", "eee@gmail.com"));
			students.add(new Student("Felix", "F", "Franks", Date.valueOf("1997-01-01"), eMajor.NURSING, "1415 Road Rd",
					"(302) 666-6666", "fff@gmail.com"));
			students.add(new Student("Gerald", "G", "Geezer", Date.valueOf("1997-02-02"), eMajor.PHYSICS,
					"1617 Place Pl", "(302) 777-7777", "ggg@gmail.com"));
			students.add(new Student("Harold", "H", "Holmes", Date.valueOf("1997-03-03"), eMajor.PHYSICS,
					"1819 I'm Running Out of Clever Street Names", "(302) 888-8888", "hhh@gmail.com"));
			students.add(new Student("Ignatius", "I", "", Date.valueOf("1997-04-04"), eMajor.COMPSCI, "2021 AHHHHHhhh",
					"(302) 999-9999", "iii@gmail.com"));
			students.add(new Student("John", "Jacod", "Jingleheimer-Schmidt", Date.valueOf("1997-05-05"),
					eMajor.COMPSCI, "2223 The Shire", "(302) 000-0000", "jjj@gmail.com"));
		} catch (PersonException e) {

		}
		for (Section section : sections) {
			for (Student student : students) {
				student.addEnrollment(student.getStudentID(), section.getSectionID(), section.getGradePoints());
			}
		}
		for (Student student : students) {
			for (Enrollment enrollment : student.getEnrollment()) {
				enrollment.setGrade(3.0);
			}
		}
	}
	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}
}