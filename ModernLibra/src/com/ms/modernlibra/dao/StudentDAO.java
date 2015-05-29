package com.ms.modernlibra.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ms.modernlibra.model.StudentVO;
import com.ms.modernlibra.util.HibernateUtils;

public class StudentDAO extends DataAccessObject {

	public StudentDAO() {
		super(StudentVO.class);
	}

	public StudentVO searchByEmailId(StudentVO studentVO) {
		StudentVO savedVO = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(StudentVO.class);
		Criterion criterion = Restrictions.ilike("emailId",
				studentVO.getEmailId());
		criteria.add(criterion);
		List<StudentVO> studentVOList = criteria.list();
		if (!studentVOList.isEmpty()) {
			savedVO = studentVOList.get(0);
		}
		return savedVO;
	}

	public List<StudentVO> searchStudent(StudentVO studentVO) {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(StudentVO.class);

		List<StudentVO> studentList = new ArrayList<StudentVO>();
		if (studentVO != null) {
			if (!StringUtils.isEmpty(studentVO.getFirstName())) {
				Criterion firstName = Restrictions.ilike("firstName",
						studentVO.getFirstName(), MatchMode.ANYWHERE);
				criteria.add(firstName);
			}

			if (!StringUtils.isEmpty(studentVO.getLastName())) {
				Criterion lastName = Restrictions.ilike("lastName",
						studentVO.getLastName(), MatchMode.ANYWHERE);
				criteria.add(lastName);
			}

			if (!StringUtils.isEmpty(studentVO.getAddmissionYear())) {
				Criterion admissionYear = Restrictions.ilike("addmissionYear",
						studentVO.getAddmissionYear(), MatchMode.EXACT);
				criteria.add(admissionYear);
			}

			if (!StringUtils.isEmpty(studentVO.getUniqueId())) {
				Criterion uniqueId = Restrictions.ilike("uniqueId",
						studentVO.getUniqueId(), MatchMode.ANYWHERE);
				criteria.add(uniqueId);
			}

			if (studentVO.getCourse().getId() != -1) {
			    Criterion courseId = Restrictions.eq("course.id",
			     		studentVO.getCourse().getId());
				criteria.add(courseId);
				}
			}

			if (!StringUtils.isEmpty(studentVO.getMobileNo())) {
				Criterion mobileNo = Restrictions.ilike("mobileNo",
						studentVO.getMobileNo(), MatchMode.ANYWHERE);
				criteria.add(mobileNo);
			}

			if (!StringUtils.isEmpty(studentVO.getStatus())) {
				Criterion status = Restrictions.ilike("status",
						studentVO.getStatus(), MatchMode.EXACT);
				criteria.add(status);
			}

		studentList = criteria.list();
		return studentList;
	}
}
