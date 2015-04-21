package com.ms.modernlibra.model;

public class BranchVO extends ValueObject {
	private String branchName;
	private String duration;
	private String numberOfSemester;
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getNumberOfSemester() {
		return numberOfSemester;
	}
	
	public void setNumberOfSemester(String numberOfSemester) {
		this.numberOfSemester = numberOfSemester;
	}
}
