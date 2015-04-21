package com.ms.modernlibra;

public class BizException extends Exception {
	private ExceptionCategory exceptionCategory;
	
	public BizException(ExceptionCategory exceptionCategory) {
		this.exceptionCategory = exceptionCategory;
	}
	
	public ExceptionCategory getExceptionCategory() {
		return exceptionCategory;
	}
}
