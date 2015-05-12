package com.ms.modernlibra;

public enum ExceptionCategory {
	SYSTEM("System Error: Contact to your system administrator"), 
	BIZ("Bisuness Exception"), 
	
	DATABASE_UPDATE_EXCEPTION("Error while updating the record in database."),
	DATABASE_INSERT_EXCEPTION("Error while inserting the record in database."), 
	
	COURSE_NAME_ALREADY_EXISTS("Course name already exists."),
	
	STUDENT_ALREADY_REGISTERED("You are already registered.");
	
	private String message;
	
	private ExceptionCategory(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	

}
