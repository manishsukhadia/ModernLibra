package com.ms.modernlibra.facade;

import java.util.ArrayList;
import java.util.List;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.dao.CourseDAO;
import com.ms.modernlibra.model.CourseVO;
import com.ms.modernlibra.transferobject.CourseTO;

//this class is used to manage the business rules.
public class ConfigurationFacade {

	public void addCourse(CourseTO courseTO) throws BizException,
			SystemException {
		CourseDAO courseDAO = new CourseDAO();
		CourseVO courseVO = CourseVO.adapt(courseTO);

		if (courseDAO.searchByBranchName(courseVO) == null) {
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

}
