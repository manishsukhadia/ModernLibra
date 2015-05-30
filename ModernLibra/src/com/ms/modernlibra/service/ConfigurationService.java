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
import com.ms.modernlibra.transferobject.StudentTO;
import com.ms.modernlibra.util.HibernateUtils;

// this class is used for create transaction and commit the transaction.
public class ConfigurationService {
	
	// Course Module.
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

	public CourseTO findDepartmentById(CourseTO requestTO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		CourseTO courseTO = new CourseTO();
		try {
			courseTO = configurationFacade.findCourseById(requestTO);
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return courseTO;
	}

	public void updateCourse(CourseTO courseTO) throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.updateCourse(courseTO);
			transaction.commit();
		} catch (SystemException se) {
			transaction.rollback();
			throw se;
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	//End/////////////////////////////////////////////////////////////////////////////////////
	
	//Student Module.
	public void addStudent(StudentTO studentTO) throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.addStudent(studentTO);
			transaction.commit();
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch(HibernateException he) {
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	
	public List<StudentTO> searchStudent(StudentTO studentTO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		List<StudentTO> studentList = new ArrayList<StudentTO>();
		try {
			studentList = configurationFacade.searchStudent(studentTO);
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return studentList;
	}
	
	public StudentTO findStudentById(StudentTO requestTO) throws SystemException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		StudentTO studentTO = new StudentTO();
		try {
			studentTO = configurationFacade.findStudentById(requestTO);
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
		return studentTO;
	}
	
	public void updateStudent(StudentTO studentTO) throws SystemException, BizException {
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		ConfigurationFacade configurationFacade = new ConfigurationFacade();
		try {
			configurationFacade.updateStudent(studentTO);
			transaction.commit();
		} catch (SystemException se) {
			transaction.rollback();
			throw se;
		} catch (BizException be) {
			transaction.rollback();
			throw be;
		} catch (HibernateException he) {
			transaction.rollback();
			throw new SystemException(ExceptionCategory.SYSTEM);
		}
	}
	//End///////////////////////////////////////////////////////////////////////////////////

	

	
	
	
}
