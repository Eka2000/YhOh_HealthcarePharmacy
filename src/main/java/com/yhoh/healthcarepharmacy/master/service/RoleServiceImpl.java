package com.yhoh.healthcarepharmacy.master.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhoh.healthcarepharmacy.exception.DuplicateRecordException;
import com.yhoh.healthcarepharmacy.exception.ResourceNotFoundException;
import com.yhoh.healthcarepharmacy.master.dto.PermissionResponse;
import com.yhoh.healthcarepharmacy.master.dto.RoleRequest;
import com.yhoh.healthcarepharmacy.master.dto.RoleResponse;
import com.yhoh.healthcarepharmacy.master.entity.Permission;
import com.yhoh.healthcarepharmacy.master.entity.Role;
import com.yhoh.healthcarepharmacy.master.repository.PermissionRepository;
import com.yhoh.healthcarepharmacy.master.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PermissionRepository perRepo;
	
	private RoleResponse mapToResponse(Role role) {
		
		RoleResponse response = new RoleResponse();
		response.setId(role.getId());
		response.setName(role.getName());
		
		Set<PermissionResponse> permissionResponses =role.getPermissions()
				.stream()
				.map(permission-> {
				PermissionResponse pr = new PermissionResponse();
				pr.setId(permission.getId());
                pr.setName(permission.getName());
                return pr;
				}).collect(Collectors.toSet());
		response.setPermissions(permissionResponses);
		
		return response;
	}

	@Override
	public RoleResponse createRole(RoleRequest roleRequest) {
		
		if (roleRepo.existsByName(roleRequest.getName())) {
			throw new DuplicateRecordException("Role already exists with name: " + roleRequest.getName());
		}
		
		Role role = new Role();
		role.setName(roleRequest.getName());
		
		if (roleRequest.getPermissionIds() != null) {
			Set<Permission> permissions = roleRequest.getPermissionIds().stream()
                    .map(id -> perRepo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Permission not found: " + id)))
                    .collect(Collectors.toSet());
            role.setPermissions(permissions);
		}
		
		Role savedRole = roleRepo.save(role);
        return mapToResponse(savedRole);
	}

	@Override
	public RoleResponse updateRole(String roleId, RoleRequest roleRequest) {
		
		Role role = roleRepo.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));
		
		if (!role.getName().equals(roleRequest.getName()) && roleRepo.existsByName(roleRequest.getName())) {
            throw new DuplicateRecordException("Role already exists with name: " + roleRequest.getName());
        }
		
		role.setName(roleRequest.getName());

        if (roleRequest.getPermissionIds() != null) {
            Set<Permission> permissions = roleRequest.getPermissionIds().stream()
                    .map(id -> perRepo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Permission not found: " + id)))
                    .collect(Collectors.toSet());
            role.setPermissions(permissions);
        }

        Role updatedRole = roleRepo.save(role);
        return mapToResponse(updatedRole);
	}

	@Override
	public RoleResponse getRoleById(String roleId) {
		
		Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));
        return mapToResponse(role);
        
	}

	@Override
	public List<RoleResponse> getAllRoles() {
		
		return roleRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteRole(String roleId) {
		
		Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));
        roleRepo.delete(role);
	}
	
	
}
