package com.example.form.model;

import java.util.List;

public class RequestForm {
	private List<Long> mappingId;
	
	private List<String> firstnames;
	
	private List<String> lastname;

	public List<Long> getMappingId() {
		return mappingId;
	}

	public void setMappingId(List<Long> mappingId) {
		this.mappingId = mappingId;
	}

	public List<String> getFirstnames() {
		return firstnames;
	}

	public void setFirstnames(List<String> firstnames) {
		this.firstnames = firstnames;
	}

	public List<String> getLastname() {
		return lastname;
	}

	public void setLastname(List<String> lastname) {
		this.lastname = lastname;
	}
}
