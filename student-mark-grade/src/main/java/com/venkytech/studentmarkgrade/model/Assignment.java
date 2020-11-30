package com.venkytech.studentmarkgrade.model;

public class Assignment {

	private String typeOfTest;
	private Double testScore;
	private Boolean isExtraAssignment;

	
	public String getTypeOfTest() {
		return typeOfTest;
	}
	public void setTypeOfTest(String typeOfTest) {
		this.typeOfTest = typeOfTest;
	}

	public Double getTestScore() {
		return testScore;
	}
	public void setTestScore(Double testScore) {
		this.testScore = testScore;
	}
	public Boolean isExtraAssignment() {
		return isExtraAssignment;
	}
	public void setIsExtraAssignment(Boolean isExtraAssignment) {
		this.isExtraAssignment = isExtraAssignment;
	}


}
