package com.yhoh.healthcarepharmacy.master.dto;

import java.util.Set;

public class RoleRequest {

	private String name; // ROLE_ADMIN, ROLE_USER
    private Set<String> permissionIds;
    
    public RoleRequest() {}

    public RoleRequest(String name, Set<String> permissionIds) {
        this.name = name;
        this.permissionIds = permissionIds;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(Set<String> permissionIds) {
		this.permissionIds = permissionIds;
	}
    
    
}
