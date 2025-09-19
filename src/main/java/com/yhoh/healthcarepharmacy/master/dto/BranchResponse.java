package com.yhoh.healthcarepharmacy.master.dto;

import java.util.UUID;

import com.yhoh.healthcarepharmacy.master.entity.BranchStatus;

public class BranchResponse {
	
	private UUID id;
    private String code;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String contactNumber;
    private BranchStatus status;
    private boolean parentBranch;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public BranchStatus getStatus() {
		return status;
	}
	public void setStatus(BranchStatus status) {
		this.status = status;
	}
	public boolean isParentBranch() {
		return parentBranch;
	}
	public void setParentBranch(boolean parentBranch) {
		this.parentBranch = parentBranch;
	}
    
    

}
