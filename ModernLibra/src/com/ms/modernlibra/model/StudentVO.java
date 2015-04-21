package com.ms.modernlibra.model;

import java.util.Date;

public class StudentVO extends ValueObject {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String branch;
	private String addmissionYear;
	private String challanNo;
	private String emailId;
	private String mobileNo;
	private String uniqueId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddmissionYear() {
		return addmissionYear;
	}
	public void setAddmissionYear(String addmissionYear) {
		this.addmissionYear = addmissionYear;
	}
	public String getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
