package com.yhoh.healthcarepharmacy.master.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="branch", uniqueConstraints = {
    @UniqueConstraint(columnNames = "code"),
    @UniqueConstraint(columnNames = "name")
})
public class Branch {
	
	@Id
	@GeneratedValue
	private UUID id;


	@Column(nullable = false, unique = true, length = 50)
	private String code;


	@Column(nullable = false, length = 100)
	private String name;


	@Column(columnDefinition = "TEXT")
	private String address;


	private String city;
	private String state;
	private String country;


	@Column(length = 10)
	private String pincode;


	@Column(length = 15)
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private BranchStatus status;


	private LocalDateTime createdAt;
	private UUID createdBy;


	private LocalDateTime updatedAt;
	private UUID updatedBy;
	
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UUID getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isParentBranch() {
		return parentBranch;
	}

	public void setParentBranch(boolean parentBranch) {
		this.parentBranch = parentBranch;
	}
	
	

}
