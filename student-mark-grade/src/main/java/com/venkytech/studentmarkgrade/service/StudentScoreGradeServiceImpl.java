package com.venkytech.studentmarkgrade.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.venkytech.studentmarkgrade.model.Assignment;
import com.venkytech.studentmarkgrade.model.ScoreGrade;

@Service
public class StudentScoreGradeServiceImpl implements StudentScoreGradeService {

	@Autowired
	Environment env;

	@Override
	public double getStudentScoreGrade(ScoreGrade scoreGrade) {
		Map<String, List<Assignment>> map = new HashMap<>();
		DecimalFormat decimalformat = new DecimalFormat("0.00");
		double weightedAverage = 0.00;
		if (scoreGrade != null) {
			List<Assignment> assignementScore = scoreGrade.getStudentScorePercent().getAssignmentScores();
			List<Assignment> assignmentList = new ArrayList<Assignment>();
			List<Assignment> extraAssignmentList = new ArrayList<Assignment>();
			List<Assignment> examsList = new ArrayList<Assignment>();
			for (Assignment assignmentObj : assignementScore) {
				if (assignmentObj.getTypeOfTest().equals("Assignment")) {
					if (!assignmentObj.isExtraAssignment()) {
						assignmentList.add(assignmentObj);
					} else if (assignmentObj.isExtraAssignment()) {
						extraAssignmentList.add(assignmentObj);
					}
				} else if (assignmentObj.getTypeOfTest().equals("Exam")) {
					examsList.add(assignmentObj);
				}
			}
			map.put("Assignment", assignmentList);
			map.put("ExtraAssignment", extraAssignmentList);
			map.put("Exams", examsList);

			weightedAverage = calculateWeightedAverage(map);
			System.out.println(decimalformat.format(weightedAverage));
		}
		return weightedAverage;
	}

	public double calculateWeightedAverage(Map<String, List<Assignment>> map) throws ArithmeticException {
		double assignmentScore = 0;
		double assingmentWeightage = 0;
		double extraAssignmentScore = 0;
		double extraAssingmentWeightage = 0;
		double examScore = 0;
		double examWeightage = 0;

		if (map != null && map.size() > 0) {
			List<Assignment> assignList = map.get("Assignment");
			for (Assignment assignObj : assignList) {
				assignmentScore += (assignObj.getTestScore()
						* Double.parseDouble(env.getProperty("teacher.assignment.weightage.percent")));
				assingmentWeightage += 10.1;
			}
			List<Assignment> ExtraAssignmentList = map.get("ExtraAssignment");
			for (Assignment assignObj : ExtraAssignmentList) {
				extraAssignmentScore += (assignmentScore / assingmentWeightage)
						+ Double.parseDouble(env.getProperty("teacher.extra.assignment.credited.perecent"));
				extraAssingmentWeightage += Double.parseDouble(env.getProperty("teacher.assignment.weightage.percent"));
				assignmentScore = 0;
				assingmentWeightage = 0;
				assignmentScore = (extraAssignmentScore
						* Double.parseDouble(env.getProperty("teacher.assignment.weightage.percent")));
				assingmentWeightage = extraAssingmentWeightage;
			}
			List<Assignment> examsList = map.get("Exams");
			for (Assignment examObjec : examsList) {
				examScore += (examObjec.getTestScore()
						* Double.parseDouble(env.getProperty("teacher.exam.weightage.percent")));
				examWeightage += 89.9;

			}

		}

		return ((assignmentScore + examScore) / (assingmentWeightage + examWeightage));
	}

}
