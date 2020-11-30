package com.venkytech.studentmarkgrade.model;

import java.util.List;

public class StudentScorePercent  {

	public List<Assignment> getAssignmentScores() {
		return assignmentScores;
	}

	public void setAssignmentScores(List<Assignment> assignmentScores) {
		this.assignmentScores = assignmentScores;
	}

	List<Assignment> assignmentScores;
	List<Double> examScores;

//List<Double> extraAssignmentScores;
	public List<Double> getExamScores() {
		return examScores;
	}

	public void setExamScores(List<Double> examScores) {
		this.examScores = examScores;
	}

}
