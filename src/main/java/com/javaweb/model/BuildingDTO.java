package com.javaweb.model;

public class BuildingDTO {
	private String name; 
	private Integer numberOfBasement; 
	private String Address; 
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer string) {
		this.numberOfBasement = string;
	} 
	
}
