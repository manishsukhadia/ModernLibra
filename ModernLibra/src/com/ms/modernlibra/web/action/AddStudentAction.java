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

public class AddStudentAction extends BaseActionSupport {

	private StudentTO studentTO = new StudentTO();
	private List<Option> courseOptionList = new ArrayList<Option>();
	private String confirmPassword;
	private String captchaCode;

	public StudentTO getStudentTO() {
		return studentTO;
	}

	public void setStudentTO(StudentTO studentTO) {
		this.studentTO = studentTO;
	}

	public List<Option> getCourseOptionList() {
		return courseOptionList;
	}

	public void setCourseOptionList(List<Option> courseOptionList) {
		this.courseOptionList = courseOptionList;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}

	@Override
	public String execute() {
		String retVal = "addStudent";
		setView();
		if (SUBMIT.equals(getSubmit())) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addStudent(studentTO);
				addActionMessage("Successfully Registered.");
				studentTO = null;
				setCaptchaCode(null);
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

			if (StringUtils.isEmpty(studentTO.getFirstName())) {
				addFieldError("studentTO.firstName",
						"First Name cannot be blank.");
			} else if (!StringUtils.isAlphaSpace(studentTO.getFirstName())) {
				addFieldError("studentTO.firstName",
						"First Name cannot contain numeric and special characters");
			}

			if (!StringUtils.isAlphaSpace(studentTO.getMiddleName())) {
				addFieldError("studentTO.middleName",
						"Middle Name cannot contain numeric and special characters");
			}

			if (StringUtils.isEmpty(studentTO.getLastName())) {
				addFieldError("studentTO.lastName",
						"Last Name cannot be blank.");
			} else if (!StringUtils.isAlphaSpace(studentTO.getLastName())) {
				addFieldError("studentTO.lastName",
						"Last Name cannot contain numeric and special characters");
			}

			if (StringUtils.isEmpty(studentTO.getGender())) {
				addFieldError("studentTO.gender", "Gender cannot be blank.");
			}

			if (studentTO.getDateOfBirth() == null) {
				addFieldError("studentTO.dateOfBirth",
						"Date Of Birth cannot be blank.");
			}

			if (studentTO.getCourse().getId() == -1) {
				addFieldError("studentTO.course.id", "Please Select one option");
			}

			if (StringUtils.isEmpty(studentTO.getAddmissionYear())) {
				addFieldError("studentTO.addmissionYear",
						"Addmission Year cannot be blank.");
			} else if (!StringUtils.isNumeric(studentTO.getAddmissionYear())) {
				addFieldError("studentTO.addmissionYear",
						"Addmission Year cannot contain alphabetic and special characters");
			}

			if (StringUtils.isEmpty(studentTO.getChallanNo())) {
				addFieldError("studentTO.challanNo",
						"Challan Number cannot be blank.");
			} else if (!StringUtils.isNumeric(studentTO.getChallanNo())) {
				addFieldError("studentTO.challanNo",
						"Challan Number cannot contain alphabetic and special characters");
			}

			// email validation.
			EmailValidator emailValidator = EmailValidator.getInstance();
			if (StringUtils.isBlank(studentTO.getEmailId())) {
				addFieldError("studentTO.emailId", "Please enter your Email Id");
			} else {
				boolean validators = emailValidator.isValid(studentTO
						.getEmailId());
				if (!validators) {
					addFieldError("studentTO.emailId", " Invalid Email Id");
				}
			}

			if (StringUtils.isEmpty(studentTO.getMobileNo())) {
				addFieldError("studentTO.mobileNo",
						"Mobile Number cannot be blank.");
			} else if (!StringUtils.isNumeric(studentTO.getMobileNo())) {
				addFieldError("studentTO.mobileNo",
						"Mobile Number cannot contain alphabetic and special characters");
			}

			if (StringUtils.isEmpty(studentTO.getPassword())) {
				addFieldError("studentTO.password", "Password cannot be blank.");
			} else if (studentTO.getPassword().length() < 8) {
				addFieldError("studentTO.password", "Password Length must be greater than 7 char.");
			}

			if (StringUtils.isEmpty(getConfirmPassword())) {
				addFieldError("confirmPassword",
						"Confirm Password field cannot be blank.");
			} else if (!studentTO.getPassword().equals(getConfirmPassword())) {
				addFieldError("confirmPassword",
						"Confirm Password field cannot match with password field.");
			}
			
			// Captcha code validation
			Map<String, Object> attibutes = ActionContext.getContext().getSession();
			Captcha captcha = (Captcha) attibutes.get(Captcha.NAME);
			if(StringUtils.isEmpty(getCaptchaCode())) {
				addFieldError("captchaCode", "Security Code cannot be blank.");
			} else if (!captcha.isCorrect(getCaptchaCode())) {
				addFieldError("captchaCode", "Not matched with Security Code.");
			}
			
			if (hasFieldErrors() || hasActionErrors()) {
				setView();
			}
		}
	}
}