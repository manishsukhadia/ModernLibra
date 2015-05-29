package com.ms.modernlibra.model;

import com.ms.modernlibra.transferobject.CourseTO;

public class CourseVO extends ValueObject {
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

	public static CourseVO adapt(CourseTO courseTO) {
		CourseVO courseVO = new CourseVO();

		courseVO.setId(courseTO.getId());
		courseVO.setCourseName(courseTO.getCourseName());
		courseVO.setDuration(courseTO.getDuration());
		courseVO.setNumberOfSemester(courseTO.getNumberOfSemester());
		
		return courseVO;
	}
}
