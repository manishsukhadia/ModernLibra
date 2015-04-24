package com.ms.modernlibra.transferobject;

import java.io.Serializable;

import com.ms.modernlibra.model.CourseVO;

public class CourseTO extends TransferObject implements Serializable {
	private String courseName;
	private String duration;
	private String numberOfSemester;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	
	public static CourseTO adapt(CourseVO courseVO) {
		CourseTO courseTO = new CourseTO();

		courseTO.setCourseName(courseVO.getCourseName());
		courseTO.setDuration(courseVO.getDuration());
		courseTO.setNumberOfSemester(courseVO.getNumberOfSemester());
		courseTO.setId(courseVO.getId());

		return courseTO;
	}
}
