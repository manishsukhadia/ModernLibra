package com.ms.modernlibra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ms.modernlibra.model.BranchVO;
import com.ms.modernlibra.util.HibernateUtils;

public class BranchDAO extends DataAccessObject {

	public BranchDAO() {
		super(BranchVO.class);
	}

	public BranchVO searchByBranchName(BranchVO branchVO) {
		BranchVO savedVO  = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(BranchVO.class);
		Criterion criterion = Restrictions.ilike("branchName", branchVO.getBranchName());
	    criteria.add(criterion);
	    List<BranchVO> branchVOList = criteria.list();
	    if(!branchVOList.isEmpty()){
	    	savedVO = branchVOList.get(0);
	    }
	    return savedVO;
	}

}
