package com.ms.modernlibra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ms.modernlibra.model.CourseVO;
import com.ms.modernlibra.util.HibernateUtils;

public class CourseDAO extends DataAccessObject {

	public CourseDAO() {
		super(CourseVO.class);
	}

	public CourseVO searchByBranchName(CourseVO courseVO) {
		CourseVO savedVO  = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(CourseVO.class);
		Criterion criterion = Restrictions.ilike("courseName", courseVO.getCourseName());
	    criteria.add(criterion);
	    List<CourseVO> branchVOList = criteria.list();
	    if(!branchVOList.isEmpty()){
	    	savedVO = branchVOList.get(0);
	    }
	    return savedVO;
	}

}
