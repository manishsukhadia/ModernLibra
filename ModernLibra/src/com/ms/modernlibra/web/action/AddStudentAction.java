package com.ms.modernlibra.web.action;

import com.ms.modernlibra.model.StudentVO;

public class AddStudentAction extends BaseActionSupport {
	
	private StudentVO studentVO = new StudentVO();

	public StudentVO getStudentVO() {
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	
	@Override
	public String execute() {
		String retVal = "addStudent";
		
		
		return retVal;
	}
}
