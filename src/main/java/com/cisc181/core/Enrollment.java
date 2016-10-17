package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	//private no-arg constructor
	private Enrollment() {
		
	}
	
	public Enrollment (UUID StudentID, UUID SectionID) {
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
	}
	
	public void setGrade (double grade) {
		this.Grade = grade;
	}
	
}
