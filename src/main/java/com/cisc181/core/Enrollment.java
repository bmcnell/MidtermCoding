package com.cisc181.core;

import java.util.ArrayList;
import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	private static ArrayList<Enrollment> enrollment;
	
	//private no-arg constructor
	private Enrollment() {
		
	}
	
	public Enrollment (UUID StudentID, UUID SectionID) {
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
		enrollment.add(this);
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}
	
	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	public double getGrade() {
		return Grade;
	}
	
	public void setGrade (double grade) {
		this.Grade = grade;
	}
	
	public static ArrayList<Enrollment> getEnrollmentlist() {
		return enrollment;
	}

}
