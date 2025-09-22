package com.yhoh.healthcarepharmacy.master.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhoh.healthcarepharmacy.exception.DuplicateRecordException;
import com.yhoh.healthcarepharmacy.exception.ResourceNotFoundException;
import com.yhoh.healthcarepharmacy.exception.ValidationException;
import com.yhoh.healthcarepharmacy.master.dto.PermissionRequest;
import com.yhoh.healthcarepharmacy.master.dto.PermissionResponse;
import com.yhoh.healthcarepharmacy.master.entity.Permission;
import com.yhoh.healthcarepharmacy.master.repository.PermissionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionRepository repo;
	
	public PermissionServiceImpl(PermissionRepository repo) {
		this.repo=repo;
	}

	private PermissionResponse mapToResponse(Permission permission) {
		
		PermissionResponse response = new PermissionResponse();
        response.setId(permission.getId());
        response.setName(permission.getName());
        // Optional: roles mapping
        if (permission.getRoles() != null) {
            response.setRoles(permission.getRoles().stream()
                    .map(r -> r.getName())
                    .collect(Collectors.toSet()));
        }
        return response;
	}
	
	
	
	@Override
	public PermissionResponse createPermission(PermissionRequest request) {
		
		if (request.getName() == null || request.getName().isEmpty()) {
			throw new ValidationException("Permission name is mandatory");
		}
		
		if (repo.existsByName(request.getName())) {
			throw new DuplicateRecordException("Permission already exists: " + request.getName());
		}
		
		Permission permission = new Permission();
        permission.setName(request.getName());
        
        Permission saved = repo.save(permission);
		return mapToResponse(saved);
	}

	@Override
	public PermissionResponse updatePermission(String id, PermissionRequest request) {
		
		Permission permission = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));
		
		if (request.getName() == null || request.getName().isEmpty()) {
            throw new ValidationException("Permission name is mandatory");
        }
		
		if (!permission.getName().equals(request.getName()) &&
                repo.existsByName(request.getName())) {
            throw new DuplicateRecordException("Permission already exists: " + request.getName());
        }
		
		permission.setName(request.getName());
        permission = repo.save(permission);

        return mapToResponse(permission);
	}

	@Override
	public void deletePermission(String id) {
		if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Permission not found with id: " + id);
        }
		
		repo.deleteById(id);
	}

	@Override
	public PermissionResponse getPermissionById(String id) {
		
		return repo.findById(id)
				.map(this::mapToResponse)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));
	}

	@Override
	public List<PermissionResponse> getAllPermissions() {
		
		return repo.findAll()
				.stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	
}
