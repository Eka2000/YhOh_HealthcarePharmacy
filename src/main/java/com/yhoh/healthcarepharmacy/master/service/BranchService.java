package com.yhoh.healthcarepharmacy.master.service;

import java.util.List;
import java.util.UUID;

import com.yhoh.healthcarepharmacy.master.dto.BranchRequest;
import com.yhoh.healthcarepharmacy.master.dto.BranchResponse;

public interface BranchService {

	BranchResponse createBranch(BranchRequest request);
	
    BranchResponse updateBranch(UUID id, BranchRequest request);
    
    BranchResponse getBranchById(UUID id);
    
    List<BranchResponse> getAllBranches();
    
    void deleteBranch(UUID id);
    
}
