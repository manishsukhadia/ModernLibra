package com.ms.modernlibra.model;

import java.util.Date;

import com.ms.modernlibra.transferobject.StudentTO;

public class StudentVO extends ValueObject {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private CourseVO course;
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

	public CourseVO getCourse() {
		return course;
	}

	public void setCourse(CourseVO course) {
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

	public static StudentVO adapt(StudentTO studentTO) {
		StudentVO studentVO = new StudentVO();

		studentVO.setId(studentTO.getId());
		studentVO.setFirstName(studentTO.getFirstName());
		studentVO.setMiddleName(studentTO.getMiddleName());
		studentVO.setLastName(studentTO.getLastName());
		studentVO.setGender(studentTO.getGender());
		studentVO.setDateOfBirth(studentTO.getDateOfBirth());
		
		if(studentTO.getCourse() != null) {
		studentVO.setCourse(CourseVO.adapt(studentTO.getCourse()));
		}
		
		studentVO.setAddmissionYear(studentTO.getAddmissionYear());
		studentVO.setChallanNo(studentTO.getChallanNo());
		studentVO.setEmailId(studentTO.getEmailId());
		studentVO.setMobileNo(studentTO.getMobileNo());
		studentVO.setUniqueId(studentTO.getUniqueId());
		studentVO.setStatus(studentTO.getStatus());
		studentVO.setPassword(studentTO.getPassword());

		return studentVO;
	}
	
}
