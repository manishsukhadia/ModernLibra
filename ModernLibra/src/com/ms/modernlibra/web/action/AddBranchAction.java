package com.ms.modernlibra.web.action;

import org.apache.commons.lang.StringUtils;

import com.ms.modernlibra.BizException;
import com.ms.modernlibra.ExceptionCategory;
import com.ms.modernlibra.SystemException;
import com.ms.modernlibra.model.BranchVO;
import com.ms.modernlibra.service.ConfigurationService;

public class AddBranchAction extends BaseActionSupport {

	private BranchVO branchVO;

	public BranchVO getBranchVO() {
		return branchVO;
	}

	public void setBranchVO(BranchVO branchVO) {
		this.branchVO = branchVO;
	}

	@Override
	public String execute() {
		String retVal = "addBranch";
		if ((getSubmit() != null) && SUBMIT.equals(getSubmit())) {
			ConfigurationService configurationService = new ConfigurationService();
			try {
				configurationService.addBranch(branchVO);
				retVal = SUCCESS;
			} catch (BizException se) {
				addActionError(se.getExceptionCategory().getMessage());
				retVal = ERROR;
			} catch(SystemException se) {
				addActionError(ExceptionCategory.SYSTEM.getMessage());
				retVal = ERROR;
			}
		}
		return retVal;
	}

	@Override
	public void validate() {
		super.validate();
		if (SUBMIT.equals(getSubmit())) {

			if (StringUtils.isEmpty(branchVO.getBranchName())) {
				addFieldError("branchVO.branchName",
						"Branch name cannot be blank.");
			} else {
				if (!StringUtils.isAlphaSpace(branchVO.getBranchName())) {
					addFieldError("branchVO.branchName",
							"Branch name cannot contain numeric and special characters");
				}
			}

			if (StringUtils.isEmpty(branchVO.getDuration())) {
				addFieldError("branchVO.duration",
						"Duration of Course cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(branchVO.getDuration())) {
					addFieldError("branchVO.duration",
							"Duration must be numeric");
				}
			}
			
			if (StringUtils.isEmpty(branchVO.getNumberOfSemester())) {
				addFieldError("branchVO.numberOfSemester",
						"Number of Semester cannot be blank.");
			} else {
				if (!StringUtils.isNumeric(branchVO.getNumberOfSemester())) {
					addFieldError("branchVO.numberOfSemester",
							"Number of Semester must be numeric");
				}
			}

		}
	}
}
