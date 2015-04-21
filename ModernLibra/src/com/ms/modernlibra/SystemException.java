package com.ms.modernlibra;

public class SystemException extends Exception {
	private ExceptionCategory exceptionCategory;

	public SystemException(ExceptionCategory exceptionCategory) {
		this.exceptionCategory = exceptionCategory;
	}

	public ExceptionCategory getExceptionCategory() {
		return exceptionCategory;
	}

}
