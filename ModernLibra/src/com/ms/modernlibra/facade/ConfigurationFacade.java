package com.ms.modernlibra.facade;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.dao.BranchDAO;
import com.ms.modernlibra.model.BranchVO;

//this class is used to manage the business rules.
public class ConfigurationFacade {

	public void addBranch(BranchVO branchVO) throws BizException, SystemException {
		BranchDAO branchDAO = new BranchDAO();
		
		if (branchDAO.searchByBranchName(branchVO) == null) {
			branchDAO.save(branchVO);
		}
		else {
			throw new BizException(ExceptionCategory.BRANCH_NAME_ALREADY_EXISTS);
		}
	}

}
