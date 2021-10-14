package com.yash.entity;

import java.io.Serializable;

public class QuizScores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int candidateId;
	private String candidateName;
	private String moduleName;
	private String status;
	private double percentage;
	
	public QuizScores() {
		super();
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Last Quiz Scores analysis \nId : " + candidateId + "\nCandidate Name : " + candidateName + "\nModule Name : "
				+ moduleName + "\nStatus : " + status + "\nPercentage : " + percentage + "]";
	}

	
	
}
