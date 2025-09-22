package com.yhoh.healthcarepharmacy.master.dto;

import java.util.Set;

public class PermissionResponse {
	
	private String id;   
    private String name; 

    // Optional: Include roles if you want to show which roles have this permission
    private Set<String> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
