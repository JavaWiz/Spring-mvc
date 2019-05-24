package com.example.model;

public class User {
	
	private String name;
	private String country;
	private String technologies;

	public User() {

	}

	public User(String name, String country, String technologies) {
		this.name = name;
		this.country = country;
		this.technologies = technologies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", country=" + country
				+ ", technologies=" + technologies + "]";
	}
}
