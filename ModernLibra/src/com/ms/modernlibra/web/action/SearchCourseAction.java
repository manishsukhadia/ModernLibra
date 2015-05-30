package com.ms.modernlibra.web.action;

import java.util.List;

import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.service.ConfigurationService;
import com.ms.modernlibra.transferobject.CourseTO;

public class SearchCourseAction extends BaseActionSupport {

	private CourseTO courseTO;
	private List<CourseTO> courseList;
	private int recordId;
	
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
	
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String execute() {
		String retVal = SUCCESS;
		ConfigurationService configurationService = new ConfigurationService();

		try {
			courseList =  configurationService.searchCourse();
			CourseTO courseTO = new CourseTO();
			courseTO.setId(getRecordId());
			if(getRecordId() != 0) {
				addActionMessage("Successfully updated.");
			}
		} catch(SystemException se) {
			addActionError(se.getExceptionCategory().getMessage());
			retVal = ERROR;
		}
		return retVal;
	}
}
