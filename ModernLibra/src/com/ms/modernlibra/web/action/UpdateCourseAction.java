package com.ms.modernlibra.web.action;

import org.apache.commons.lang.StringUtils;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.service.ConfigurationService;
import com.ms.modernlibra.transferobject.CourseTO;

public class UpdateCourseAction extends BaseActionSupport {

	private CourseTO courseTO;
	private int id;

	public CourseTO getCourseTO() {
		return courseTO;
	}

	public void setCourseTO(CourseTO courseTO) {
		this.courseTO = courseTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() {
		String retVal = "updateCourse";
		ConfigurationService configurationService = new ConfigurationService();

		if (SUBMIT.equals(getSubmit())) {
			try {
				configurationService.updateCourse(courseTO);
				setId(courseTO.getId());
				retVal = SUCCESS;
			} catch (SystemException se) {
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch (BizException be) {
				addActionError(be.getExceptionCategory().getMessage());
				retVal = ERROR;
			}
		} else {
			CourseTO courseTO = new CourseTO();
			courseTO.setId(getId());
			try {
				courseTO = configurationService.findDepartmentById(courseTO);
			} catch (SystemException se) {
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			}
			setCourseTO(courseTO);
		}
		return retVal;
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {

			if (StringUtils.isEmpty(courseTO.getCourseName())) {
				addFieldError("courseTO.courseName",
						"Course name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(courseTO.getCourseName())) {
					addFieldError("courseTO.courseName",
							"Course name cannot contain numeric and special characters");
				}
			}

			if (StringUtils.isEmpty(courseTO.getDuration())) {
				addFieldError("courseTO.duration",
						"Duration of Course cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(courseTO.getDuration())) {
					addFieldError("courseTO.duration",
							"Duration must be numeric");
				}
			}

			if (StringUtils.isEmpty(courseTO.getNumberOfSemester())) {
				addFieldError("courseTO.numberOfSemester",
						"Number of Semester cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(courseTO.getNumberOfSemester())) {
					addFieldError("courseTO.numberOfSemester",
							"Number of Semester must be numeric");
				}
			}
		}
	}
}
