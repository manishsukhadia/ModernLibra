package com.ms.modernlibra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ms.modernlibra.model.CourseVO;
import com.ms.modernlibra.model.StudentVO;
import com.ms.modernlibra.util.HibernateUtils;

public class StudentDAO extends DataAccessObject {
	
	public StudentDAO() {
		super(StudentVO.class);
	}
	
	public StudentVO searchByEmailId(StudentVO studentVO) {
		StudentVO savedVO  = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(StudentVO.class);
		Criterion criterion = Restrictions.ilike("emailId", studentVO.getEmailId());
	    criteria.add(criterion);
	    List<StudentVO> studentVOList = criteria.list();
	    if(!studentVOList.isEmpty()){
	    	savedVO = studentVOList.get(0);
	    }
	    return savedVO;
	}
}
