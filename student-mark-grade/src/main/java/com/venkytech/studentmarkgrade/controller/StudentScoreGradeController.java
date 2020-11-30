package com.venkytech.studentmarkgrade.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.venkytech.studentmarkgrade.model.Assignment;
import com.venkytech.studentmarkgrade.model.ScoreGrade;
import com.venkytech.studentmarkgrade.model.StudentScorePercent;
import com.venkytech.studentmarkgrade.service.StudentScoreGradeService;

@RestControllerAdvice
@RequestMapping("/studentGrade")
public class StudentScoreGradeController {

	@Autowired
	private StudentScoreGradeService studentScoreGradeService;

	@Autowired
	private AbstractEnvironment env;

	@RequestMapping("/studentScoreGrade")
	public String getStudentScoreGrade() {
		ScoreGrade scoreGrade = new ScoreGrade();
		DecimalFormat df = new DecimalFormat("0.00");
		scoreGrade = initializeStudentMarks();
		double finalGrade = getStudentScoreGrade(scoreGrade);
		return df.format(finalGrade);
	}

	public double getStudentScoreGrade(ScoreGrade scoreGrade) {
		double finalGrade = studentScoreGradeService.getStudentScoreGrade(scoreGrade);
		return finalGrade;
	}

	private ScoreGrade initializeStudentMarks() {
		Map<String, List<Assignment>> map = new LinkedHashMap<>();
		ScoreGrade scoreGrade = new ScoreGrade();

		StudentScorePercent studObject = new StudentScorePercent();
		List<Assignment> assignList = new ArrayList<Assignment>();
		Assignment assignement = new Assignment();
		assignement.setTypeOfTest("Assignment");
		assignement.setTestScore(85.0);
		assignement.setIsExtraAssignment(false);
		assignList.add(assignement);

		Assignment assignement2 = new Assignment();
		assignement2.setTypeOfTest("Assignment");
		assignement2.setTestScore(88.0);
		assignement2.setIsExtraAssignment(false);
		assignList.add(assignement2);

		Assignment assignement4 = new Assignment();
		assignement4.setTypeOfTest("Assignment");
		assignement4.setTestScore(92.0);
		assignement4.setIsExtraAssignment(false);
		assignList.add(assignement4);

		Assignment assignement3 = new Assignment();
		// assignement3.setTestScore(88.0);
		assignement3.setTypeOfTest("Assignment");
		assignement3.setIsExtraAssignment(true);
		assignList.add(assignement3);

		Assignment exam = new Assignment();
		exam.setTypeOfTest("Exam");
		exam.setTestScore(91.0);
		exam.setIsExtraAssignment(false);
		assignList.add(exam);

		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		return scoreGrade;
	}
}
