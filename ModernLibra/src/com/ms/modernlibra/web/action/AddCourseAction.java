package com.ms.modernlibra.web.action;

import org.apache.commons.lang.StringUtils;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.model.CourseVO;
import com.ms.modernlibra.service.ConfigurationService;

public class AddCourseAction extends BaseActionSupport {

	private CourseVO courseVO;

	public CourseVO getCourseVO() {
		return courseVO;
	}

	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}

	@Override
	public String execute() {
		String retVal = "addCourse";
		if ((getSubmit() != null) && SUBMIT.equals(getSubmit())) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addCourse(courseVO);
				addActionMessage("Successfully Record Added.");
				retVal = SUCCESS;
			} catch (BizException be) {
				addActionError(be.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch(SystemException se) {
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

			if (StringUtils.isEmpty(courseVO.getCourseName())) {
				addFieldError("courseVO.courseName",
						"Course name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(courseVO.getCourseName())) {
					addFieldError("courseVO.courseName",
							"Course name cannot contain numeric and special characters");
				}
			}

			if (StringUtils.isEmpty(courseVO.getDuration())) {
				addFieldError("courseVO.duration",
						"Duration of Course cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(courseVO.getDuration())) {
					addFieldError("courseVO.duration",
							"Duration must be numeric");
				}
			}
			
			if (StringUtils.isEmpty(courseVO.getNumberOfSemester())) {
				addFieldError("courseVO.numberOfSemester",
						"Number of Semester cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(courseVO.getNumberOfSemester())) {
					addFieldError("courseVO.numberOfSemester",
							"Number of Semester must be numeric");
				}
			}

		}
	}
}
