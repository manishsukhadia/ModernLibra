package com.ms.modernlibra.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.facade.ConfigurationFacade;
import com.ms.modernlibra.transferobject.CourseTO;
import com.ms.modernlibra.util.HibernateUtils;

// this class is used for create transaction and commit the transaction.
public class ConfigurationService {
	
	public void addCourse(CourseTO courseTO) throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.addCourse(courseTO);
			transaction.commit();
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}

	public List<CourseTO> searchCourse() throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<CourseTO> courseList = new ArrayList<CourseTO>();
		try {
			courseList = configurationFacade.searchCourse();
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return courseList;
	}
}
