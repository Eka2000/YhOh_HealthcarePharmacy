package com.yhoh.healthcarepharmacy.master.service;

import java.util.List;

import com.yhoh.healthcarepharmacy.master.dto.PermissionRequest;
import com.yhoh.healthcarepharmacy.master.dto.PermissionResponse;

public interface PermissionService {
	
	PermissionResponse createPermission(PermissionRequest dto);
	
    PermissionResponse updatePermission(String id, PermissionRequest dto);
    
    void deletePermission(String id);
    
    PermissionResponse getPermissionById(String id);
    
    List<PermissionResponse> getAllPermissions();

}
