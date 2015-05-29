package com.ms.modernlibra.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.captcha.Captcha;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.EmailValidator;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.service.ConfigurationService;
import com.ms.modernlibra.transferobject.CourseTO;
import com.ms.modernlibra.transferobject.StudentTO;
import com.ms.modernlibra.web.util.Option;
import com.opensymphony.xwork2.ActionContext;

public class SearchStudentAction extends BaseActionSupport {

	private StudentTO studentTO;
	private List<StudentTO> studentList;
	private List<Option> courseOptionList = new ArrayList<Option>();
	private int id;

	public StudentTO getStudentTO() {
		return studentTO;
	}

	public void setStudentTO(StudentTO studentTO) {
		this.studentTO = studentTO;
	}

	public List<StudentTO> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentTO> studentList) {
		this.studentList = studentList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Option> getCourseOptionList() {
		return courseOptionList;
	}

	public void setCourseOptionList(List<Option> courseOptionList) {
		this.courseOptionList = courseOptionList;
	}

	public String execute() throws SystemException, BizException {
		String retVal = SUCCESS;
		setView();

		try {
			if (SUBMIT.equals(getSubmit())) {
				ConfigurationService configurationService = new ConfigurationService();
				studentList = configurationService.searchStudent(studentTO);
				retVal = SUCCESS;

			} else {
				StudentTO studentTO = new StudentTO();
				studentTO.setId(getId());
				if (getId() != 0) {
					addActionMessage("Successfully updated.");
				}
			}
		} catch (SystemException se) {
			addActionError(se.getExceptionCategory().getMessage());
			retVal = ERROR;
		}
		return retVal;
	}

	private void setView() {
		ConfigurationService configurationService = new ConfigurationService();
		List<CourseTO> courseList = new ArrayList<CourseTO>();

		try {
			courseList = configurationService.searchCourse();
		} catch (SystemException se) {
			addActionError(se.getExceptionCategory().getMessage());
		}

		Option option = new Option();
		option.setLabel("Select Course");
		option.setValue(-1);
		courseOptionList.add(option);
		for (CourseTO courseTO : courseList) {
			option = new Option();
			option.setLabel(courseTO.getCourseName());
			option.setValue(courseTO.getId());
			courseOptionList.add(option);
		}
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {

			if (!StringUtils.isAlphaSpace(studentTO.getFirstName())) {
				addFieldError("studentTO.firstName",
						"First Name cannot contain numeric and special characters");
			}

			if (!StringUtils.isAlphaSpace(studentTO.getLastName())) {
				addFieldError("studentTO.lastName",
						"Last Name cannot contain numeric and special characters");
			}

			if (!StringUtils.isNumeric(studentTO.getAddmissionYear())) {
				addFieldError("studentTO.addmissionYear",
						"Addmission Year cannot contain alphabetic and special characters");
			}

			if (!StringUtils.isNumeric(studentTO.getMobileNo())) {
				addFieldError("studentTO.mobileNo",
						"Mobile Number cannot contain alphabetic and special characters");
			}

			if (hasFieldErrors() || hasActionErrors()) {
				setView();
			}
		}
	}
}
