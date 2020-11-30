package com.venkytech.studentmarkgrade.model;

public class ScoreGrade {

	private StudentScorePercent studentScorePercent;
	private TeacherPercentAllocation teacherPercentAllocation;
	public StudentScorePercent getStudentScorePercent() {
		return studentScorePercent;
	}
	public void setStudentScorePercent(StudentScorePercent studentScorePercent) {
		this.studentScorePercent = studentScorePercent;
	}
	public TeacherPercentAllocation getTeacherPercentAllocation() {
		return teacherPercentAllocation;
	}
	public void setTeacherPercentAllocation(TeacherPercentAllocation teacherPercentAllocation) {
		this.teacherPercentAllocation = teacherPercentAllocation;
	}
	
	
}
