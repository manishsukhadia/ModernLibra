package com.ms.modernlibra.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.dao.CourseDAO;
import com.ms.modernlibra.dao.StudentDAO;
import com.ms.modernlibra.model.CourseVO;
import com.ms.modernlibra.model.StudentVO;
import com.ms.modernlibra.transferobject.CourseTO;
import com.ms.modernlibra.transferobject.StudentTO;

//this class is used to manage the business rules.
public class ConfigurationFacade {

	// Course Module.
	public void addCourse(CourseTO courseTO) throws BizException,
			SystemException {
		CourseDAO courseDAO = new CourseDAO();
		CourseVO courseVO = CourseVO.adapt(courseTO);

		if (courseDAO.searchByCourseName(courseVO) == null) {
			courseDAO.save(courseVO);
			courseTO = CourseTO.adapt(courseVO);
		} else {
			throw new BizException(ExceptionCategory.COURSE_NAME_ALREADY_EXISTS);
		}
	}

	public List<CourseTO> searchCourse() throws SystemException {
		CourseDAO courseDAO = new CourseDAO();
		List<CourseVO> courseVOList = courseDAO.searchCourse();
		List<CourseTO> courseTOList = new ArrayList<CourseTO>();
		for (CourseVO cosurseVO : courseVOList) {
			CourseTO courseTO = CourseTO.adapt(cosurseVO);
			courseTOList.add(courseTO);
		}
		return courseTOList;
	}

	public CourseTO findCourseById(CourseTO requestTO) {
		CourseTO returnVal = null;
		CourseDAO courseDAO = new CourseDAO();

		CourseVO courseVO = CourseVO.adapt(requestTO);
		courseVO = (CourseVO) courseDAO.findById(courseVO);

		if (courseVO != null) {
			returnVal = CourseTO.adapt(courseVO);
		}
		return returnVal;
	}

	public void updateCourse(CourseTO courseTO) throws SystemException,
			BizException {
		CourseDAO courseDAO = new CourseDAO();

		CourseVO courseVO = CourseVO.adapt(courseTO);

		CourseVO savedVO = courseDAO.searchByCourseName(courseVO);

		if (savedVO == null) {
			courseDAO.update(courseVO);
		} else if (savedVO.getId() == courseVO.getId()) {
			savedVO.setCourseName(courseVO.getCourseName());
			savedVO.setDuration(courseVO.getDuration());
			savedVO.setNumberOfSemester(courseVO.getNumberOfSemester());
			courseDAO.update(savedVO);
		} else {
			throw new BizException(ExceptionCategory.COURSE_NAME_ALREADY_EXISTS);
		}

	}

	// End of Course Module
	// ////////////////////////////////////////////////////////////

	// Student Module
	public void addStudent(StudentTO studentTO) throws BizException,
			SystemException {
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = StudentVO.adapt(studentTO);

		if (studentDAO.searchByEmailId(studentVO) == null) {
			studentVO.setStatus("inactive"); // setting status as inactive.
			studentVO.setUniqueId(ConfigurationFacade
					.uniqueIdGenerator(studentVO));
			studentDAO.save(studentVO);
			studentTO = StudentTO.adapt(studentVO);
		} else {
			throw new BizException(ExceptionCategory.STUDENT_ALREADY_REGISTERED);
		}
	}

	// uniqueId Generator
	private static String uniqueIdGenerator(StudentVO studentVO) {
		// unique id = college prefix + separator + admission year + separator +
		// course id +
		// separator + mills;

		String collegePrefix = "MBM";
		String admissionYear = studentVO.getAddmissionYear();
		int courseId = studentVO.getCourse().getId();
		String separator = "/";
		long milliSec = Calendar.getInstance().getTimeInMillis();

		String uniqueId = collegePrefix + separator + admissionYear + separator
				+ courseId + separator + milliSec;

		return uniqueId;
	}

	public List<StudentTO> searchStudent(StudentTO studentTO)
			throws SystemException {
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = StudentVO.adapt(studentTO);

		List<StudentVO> studentVOList = studentDAO.searchStudent(studentVO);

		List<StudentTO> studentTOList = new ArrayList<StudentTO>();
		for (StudentVO stuVO : studentVOList) {
			StudentTO stuTO = StudentTO.adapt(stuVO);
			studentTOList.add(stuTO);
		}
		return studentTOList;
	}

	public StudentTO findStudentById(StudentTO requestTO) {
		StudentTO returnVal = null;
		StudentDAO studentDAO = new StudentDAO();

		StudentVO studentVO = StudentVO.adapt(requestTO);
		studentVO = (StudentVO) studentDAO.findById(studentVO);

		if (studentVO != null) {
			returnVal = StudentTO.adapt(studentVO);
		}
		return returnVal;
	}

	public void updateStudent(StudentTO studentTO) throws SystemException,
			BizException {
		StudentDAO studentDAO = new StudentDAO();

		StudentVO studentVO = StudentVO.adapt(studentTO);

		StudentVO savedVO = studentDAO.searchByEmailId(studentVO);

		if (savedVO == null) {
			studentDAO.update(studentVO);
		} else if (savedVO.getId() == studentVO.getId()) {
			savedVO.setFirstName(studentVO.getFirstName());
			savedVO.setMiddleName(studentVO.getMiddleName());
			savedVO.setLastName(studentVO.getLastName());
			savedVO.setGender(studentVO.getGender());
			savedVO.setDateOfBirth(studentVO.getDateOfBirth());
			savedVO.setCourse(studentVO.getCourse());
			savedVO.setAddmissionYear(studentVO.getAddmissionYear());
			savedVO.setChallanNo(studentVO.getChallanNo());
			savedVO.setEmailId(studentVO.getEmailId());
			savedVO.setMobileNo(studentVO.getMobileNo());
			savedVO.setUniqueId(studentVO.getUniqueId());
			savedVO.setStatus(studentVO.getStatus());
			savedVO.setPassword(studentVO.getPassword());
			studentDAO.update(savedVO);
			} else {
			throw new BizException(ExceptionCategory.STUDENT_ALREADY_REGISTERED);
			}
	}

	// End//////////////////////////////////////////////////////////////////////////
}
