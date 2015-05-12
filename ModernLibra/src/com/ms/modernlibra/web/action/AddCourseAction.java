package com.ms.modernlibra.web.action;

import org.apache.commons.lang.StringUtils;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.service.ConfigurationService;
import com.ms.modernlibra.transferobject.CourseTO;

public class AddCourseAction extends BaseActionSupport {

	private CourseTO courseTO;

	public CourseTO getCourseTO() {
		return courseTO;
	}

	public void setCourseTO(CourseTO courseTO) {
		this.courseTO = courseTO;
	}

	@Override
	public String execute() {
		String retVal = "addCourse";
		if ((getSubmit() != null) && SUBMIT.equals(getSubmit())) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addCourse(courseTO);
				addActionMessage("Successfully Course ''"
						+ courseTO.getCourseName() + "'' Added.");
				courseTO = null;
				retVal = SUCCESS;
			} catch (BizException be) {
				addActionError(be.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch (SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			}
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
			} else if (!StringUtils.isAlphaSpace(courseTO.getCourseName())) {
				addFieldError("courseTO.courseName",
						"Course name cannot contain numeric and special characters");
			}

			if (StringUtils.isEmpty(courseTO.getDuration())) {
				addFieldError("courseTO.duration",
						"Duration of Course cannot be blank.");
			} else if (!StringUtils.isNumeric(courseTO.getDuration())) {
				addFieldError("courseTO.duration", "Duration must be numeric");
			}

			if (StringUtils.isEmpty(courseTO.getNumberOfSemester())) {
				addFieldError("courseTO.numberOfSemester",
						"Number of Semester cannot be blank.");
			} else if (!StringUtils.isNumeric(courseTO.getNumberOfSemester())) {
				addFieldError("courseTO.numberOfSemester",
						"Number of Semester must be numeric");
			}

		}
	}
}
