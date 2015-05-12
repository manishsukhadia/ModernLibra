package com.ms.modernlibra.facade;

import java.util.ArrayList;
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

	public CourseTO findDepartmentById(CourseTO requestTO) {
		CourseTO returnVal = null;
		CourseDAO courseDAO = new CourseDAO();

		CourseVO courseVO = CourseVO.adapt(requestTO);
		courseVO = (CourseVO) courseDAO.findById(courseVO);

		if (courseVO != null) {
			returnVal = CourseTO.adapt(courseVO);
		}
		return returnVal;
	}

	public void updatecourse(CourseTO courseTO) throws SystemException,
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

	// End of Course Module ////////////////////////////////////////////////////////////
	
	//Student Module
	public void addStudent(StudentTO studentTO) throws BizException,
			SystemException {
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = StudentVO.adapt(studentTO);
		
		if (studentDAO.searchByEmailId(studentVO) == null) {
			studentVO.setStatus("inactive");
			studentVO.setUniqueId("1234567890");
			studentDAO.save(studentVO);
			studentTO = StudentTO.adapt(studentVO);
		} else {
			throw new BizException(ExceptionCategory.STUDENT_ALREADY_REGISTERED);
		}
	}
}
