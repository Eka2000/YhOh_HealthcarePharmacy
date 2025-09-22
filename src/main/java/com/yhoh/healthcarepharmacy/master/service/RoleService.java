package com.yhoh.healthcarepharmacy.master.service;

import java.util.List;

import com.yhoh.healthcarepharmacy.master.dto.RoleRequest;
import com.yhoh.healthcarepharmacy.master.dto.RoleResponse;

public interface RoleService {
	
    RoleResponse createRole(RoleRequest roleRequest);

    RoleResponse updateRole(String roleId, RoleRequest roleRequest);

    RoleResponse getRoleById(String roleId);

    List<RoleResponse> getAllRoles();

    void deleteRole(String roleId);

}
