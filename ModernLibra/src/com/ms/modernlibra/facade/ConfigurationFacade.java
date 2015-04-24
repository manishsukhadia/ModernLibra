package com.ms.modernlibra.facade;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.dao.CourseDAO;
import com.ms.modernlibra.model.CourseVO;

//this class is used to manage the business rules.
public class ConfigurationFacade {

	public void addCourse(CourseVO courseVO) throws BizException, SystemException {
		CourseDAO courseDAO = new CourseDAO();
		
		if (courseDAO.searchByBranchName(courseVO) == null) {
			courseDAO.save(courseVO);
		}
		else {
			throw new BizException(ExceptionCategory.COURSE_NAME_ALREADY_EXISTS);
		}
	}

}
