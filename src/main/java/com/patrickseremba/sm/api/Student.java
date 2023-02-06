package com.patrickseremba.sm.api;

public class Student {
	private int id;
	private String name;
	private Long mobile;
	private String country;

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getMobile() {
		return mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}

}
