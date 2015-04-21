package com.ms.modernlibra.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseActionSupport extends ActionSupport {
	
	private String submit;
	public static String SUBMIT = "submit";

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
