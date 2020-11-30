package com.venkytech.studentmarkgrade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.venkytech.studentmarkgrade.controller.StudentScoreGradeController;
import com.venkytech.studentmarkgrade.model.Assignment;
import com.venkytech.studentmarkgrade.model.ScoreGrade;
import com.venkytech.studentmarkgrade.model.StudentScorePercent;
import com.venkytech.studentmarkgrade.service.StudentScoreGradeService;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StudentMarkGradeApplicationTests {
	@LocalServerPort
	int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private StudentScoreGradeService studentScoreGradeService;
	
	@Autowired
	private StudentScoreGradeController studentScoreGradeController;

	DecimalFormat df = new DecimalFormat("0.00");
	@Test
	void getStudentScoreGradeTestCase1() {
		Map<String, List<Assignment>> map = new LinkedHashMap<>();
		ScoreGrade scoreGrade = new ScoreGrade();

		StudentScorePercent studObject = new StudentScorePercent();
		List<Assignment> assignList = new ArrayList<Assignment>();
		Assignment assignement = new Assignment();
		assignement.setTypeOfTest("Assignment");
		assignement.setTestScore(85.0);
		assignement.setIsExtraAssignment(false);
		assignList.add(assignement);
		
		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		double grade=studentScoreGradeController.getStudentScoreGrade(scoreGrade);
		assertEquals(String.valueOf(assignList.get(0).getTestScore()),String.valueOf(grade));
	
		
	}
	
	@Test
	void getStudentScoreGradeTestCase2() {
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
		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		
		
		double grade=studentScoreGradeController.getStudentScoreGrade(scoreGrade);
		assertEquals(String.valueOf(86.5),String.valueOf(grade));
	}

	@Test
	void getStudentScoreGradeTestCase3() {
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
		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		
		Assignment assignement3 = new Assignment();
		// assignement3.setTestScore(88.0);
		assignement3.setTypeOfTest("Assignment");
		assignement3.setIsExtraAssignment(true);
		assignList.add(assignement3);
		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		
		double grade=studentScoreGradeController.getStudentScoreGrade(scoreGrade);
		assertEquals(String.valueOf(88.5),String.valueOf(grade));
	}
	
	@Test
	void getStudentScoreGradeTestCase4() {
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
		
		double grade=studentScoreGradeController.getStudentScoreGrade(scoreGrade);
		assertEquals(String.valueOf(90.93),String.valueOf(df.format(grade)));
	}
	
	@Test
	void getStudentScoreGradeTestCase5() {
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

		/*
		 * Assignment exam = new Assignment(); exam.setTypeOfTest("Exam");
		 * exam.setTestScore(91.0); exam.setIsExtraAssignment(false);
		 * assignList.add(exam);
		 */

		studObject.setAssignmentScores(assignList);
		scoreGrade.setStudentScorePercent(studObject);
		
		double grade=studentScoreGradeController.getStudentScoreGrade(scoreGrade);
		assertEquals(String.valueOf(90.33),String.valueOf(df.format(grade)));
	}

}
