package com.yhoh.healthcarepharmacy.employee.entity;

import org.hibernate.annotations.GenericGenerator;

import com.yhoh.healthcarepharmacy.master.entity.Branch;
import com.yhoh.healthcarepharmacy.master.entity.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false, nullable = false, length = 36)
	private String id;
	
	@OneToOne
	@JoinColumn(name="employee_id",nullable=false,unique=true)
	private Employee employee;
	
	@Column(nullable = false, unique = true, length = 50)
    private String username;
	
	@Column(nullable = false, length = 200)
    private String password;
	
	@Column(nullable = false, unique = true, length = 100)
    private String email;
	
	@ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
	
	@ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    private String resetPasswordToken;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	
}
