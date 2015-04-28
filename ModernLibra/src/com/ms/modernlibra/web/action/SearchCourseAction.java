package com.ms.modernlibra.web.action;

import java.util.List;

import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.service.ConfigurationService;
import com.ms.modernlibra.transferobject.CourseTO;

public class SearchCourseAction extends BaseActionSupport {

	private CourseTO courseTO;
	private List<CourseTO> courseList;
	private int id;
	
	public CourseTO getCourseTO() {
		return courseTO;
	}
	public void setCourseTO(CourseTO courseTO) {
		this.courseTO = courseTO;
	}
	public List<CourseTO> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CourseTO> courseList) {
		this.courseList = courseList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute() {
		String retVal = SUCCESS;
		ConfigurationService configurationService = new ConfigurationService();

		try {
			courseList =  configurationService.searchCourse();
			CourseTO courseTO = new CourseTO();
			courseTO.setId(getId());
			if(getId() != 0) {
				addActionMessage("Successfully updated.");
			}
		} catch(SystemException se) {
			addActionError(se.getExceptionCategory().getMessage());
			retVal = ERROR;
		}
		return retVal;
	}
}
