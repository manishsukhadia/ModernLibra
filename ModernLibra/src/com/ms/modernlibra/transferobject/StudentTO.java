package com.ms.modernlibra.transferobject;

import java.util.Date;

import com.ms.modernlibra.model.StudentVO;

public class StudentTO extends TransferObject {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private CourseTO course; 
	private String addmissionYear;
	private String challanNo;
	private String emailId;
	private String mobileNo;
	private String uniqueId;
	private String status;
	private String password;
	
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
	public CourseTO getCourse() {
		return course;
	}
	public void setCourse(CourseTO course) {
		this.course = course;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static StudentTO adapt(StudentVO studentVO) {
		StudentTO studentTO = new StudentTO();

		studentTO.setId(studentVO.getId());
		studentTO.setFirstName(studentVO.getFirstName());
		studentTO.setMiddleName(studentVO.getMiddleName());
		studentTO.setLastName(studentVO.getLastName());
		studentTO.setGender(studentVO.getGender());
		studentTO.setDateOfBirth(studentVO.getDateOfBirth());
	
		if(studentVO.getCourse() != null) {
		studentTO.setCourse(CourseTO.adapt(studentVO.getCourse()));
		}
		
		studentTO.setAddmissionYear(studentVO.getAddmissionYear());
		studentTO.setChallanNo(studentVO.getChallanNo());
		studentTO.setEmailId(studentVO.getEmailId());
		studentTO.setMobileNo(studentVO.getMobileNo());
		studentTO.setUniqueId(studentVO.getUniqueId());
		studentTO.setStatus(studentVO.getStatus());
		studentTO.setPassword(studentVO.getPassword());

		return studentTO;

	}
}
