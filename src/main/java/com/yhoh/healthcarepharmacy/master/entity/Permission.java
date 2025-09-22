package com.yhoh.healthcarepharmacy.master.entity;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="permissions")
public class Permission {

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="id",updatable=false,nullable=false,length=36)
	private String id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "permissions",fetch = FetchType.LAZY)
	private Set<Role> roles;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
