package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;

	public Course(String CourseName) {
	}

	public int getGradePoints() {
		return this.GradePoints;
	}
}
