package com.cisc181.core;

import java.util.ArrayList;
import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	private ArrayList<Enrollment> enrollment;
	
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
	
	public ArrayList<Enrollment> getEnrollment() {
		return this.enrollment;
	}

	public void setEnrollment(ArrayList<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	public void addEnrollment(UUID StudentID, UUID SectionID, int GradePoints) {
		Enrollment newEnrollment = new Enrollment(StudentID, SectionID);
		ArrayList<Enrollment> e = new ArrayList<Enrollment>();
		if (this.enrollment != null) {
			for (Enrollment enrollment : this.getEnrollment()) {
				e.add(enrollment);
			}
		} else {
			this.enrollment = new ArrayList<Enrollment>();
		}
		e.add(newEnrollment);
		this.setEnrollment(e);
	}

	public void removeEnrollment(Enrollment dropped) {
		this.enrollment.remove(dropped);
	}
}
