package com.projectjuni.projectjunidemo.repositories;

import org.springframework.stereotype.Component;

@Component
public class TestPojo {

	private String testvar;

	public String getTestvar() {
		return "passed";
	}

	public void setTestvar(String testvar) {
		this.testvar = testvar;
	}
	
	
}
