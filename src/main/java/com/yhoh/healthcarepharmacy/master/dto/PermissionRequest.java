package com.yhoh.healthcarepharmacy.master.dto;

import java.util.Set;

public class PermissionRequest {
	
	 private String name;
	 private Set<String> roleIds; // Optional: Assign roles to permission

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public Set<String> getRoleIds() {
		 return roleIds;
	 }

	 public void setRoleIds(Set<String> roleIds) {
		 this.roleIds = roleIds;
	 }

	 
}
