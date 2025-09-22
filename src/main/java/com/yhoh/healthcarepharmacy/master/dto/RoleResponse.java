package com.yhoh.healthcarepharmacy.master.dto;

import java.util.Set;

public class RoleResponse {
	
	private String id;
    private String name;
    private Set<PermissionResponse> permissions; 
    
    // Optional: include role users if needed
    private Set<String> users;

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

	public Set<PermissionResponse> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionResponse> permissions) {
		this.permissions = permissions;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}
    
}
