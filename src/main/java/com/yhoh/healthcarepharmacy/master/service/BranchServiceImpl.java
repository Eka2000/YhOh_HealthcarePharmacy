package com.yhoh.healthcarepharmacy.master.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yhoh.healthcarepharmacy.exception.DuplicateRecordException;
import com.yhoh.healthcarepharmacy.exception.ResourceNotFoundException;
import com.yhoh.healthcarepharmacy.exception.ValidationException;
import com.yhoh.healthcarepharmacy.master.dto.BranchRequest;
import com.yhoh.healthcarepharmacy.master.dto.BranchResponse;
import com.yhoh.healthcarepharmacy.master.entity.Branch;
import com.yhoh.healthcarepharmacy.master.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService{
	
	private final BranchRepository repo;
	
	public BranchServiceImpl(BranchRepository repo) {
		this.repo = repo;
	}
	
	private BranchResponse mapToResponse(Branch branch) {
        BranchResponse response = new BranchResponse();
        response.setId(branch.getId());
        response.setCode(branch.getCode());
        response.setName(branch.getName());
        response.setAddress(branch.getAddress());
        response.setCity(branch.getCity());
        response.setState(branch.getState());
        response.setCountry(branch.getCountry());
        response.setPincode(branch.getPincode());
        response.setContactNumber(branch.getContactNumber());
        response.setStatus(branch.getStatus());
        response.setParentBranch(branch.isParentBranch());
        return response;
    }

	@Override
	public BranchResponse createBranch(BranchRequest request) {

		if (repo.existsByCode(request.getCode())) {
			throw new DuplicateRecordException("Branch code already exists: " + request.getCode());
		}
		
		if (repo.existsByName(request.getName())) {
		        throw new DuplicateRecordException("Branch name already exists: " + request.getName());
		    }
		 
		if (request.getCode() == null || request.getCode().isEmpty()) {
		        throw new ValidationException("Branch code is mandatory");
		    }
		if (request.getName() == null || request.getName().isEmpty()) {
		        throw new ValidationException("Branch name is mandatory");
		    }


		Branch branch = new Branch();
	    branch.setCode(request.getCode());
	    branch.setName(request.getName());
	    branch.setAddress(request.getAddress());
	    branch.setCity(request.getCity());
	    branch.setState(request.getState());
	    branch.setCountry(request.getCountry());
	    branch.setPincode(request.getPincode());
	    branch.setContactNumber(request.getContactNumber());
	    branch.setStatus(request.getStatus());
	    branch.setParentBranch(request.isParentBranch());
	    branch.setCreatedAt(LocalDateTime.now());

	     branch = repo.save(branch);
	    return mapToResponse(branch);
	}

	@Override
	public BranchResponse updateBranch(UUID id, BranchRequest request) {
		
		Branch branch = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", id));
		
		if (!branch.getCode().equals(request.getCode()) &&
	            repo.existsByCode(request.getCode())) {
	        throw new DuplicateRecordException("Branch code already exists: " + request.getCode());
	    }

	    if (!branch.getName().equals(request.getName()) &&
	            repo.existsByName(request.getName())) {
	        throw new DuplicateRecordException("Branch name already exists: " + request.getName());
	    }
	    
	    branch.setName(request.getName());
	    branch.setAddress(request.getAddress());
	    branch.setCity(request.getCity());
	    branch.setState(request.getState());
	    branch.setCountry(request.getCountry());
	    branch.setPincode(request.getPincode());
	    branch.setContactNumber(request.getContactNumber());
	    branch.setStatus(request.getStatus());
	    branch.setParentBranch(request.isParentBranch());
	    branch.setUpdatedAt(LocalDateTime.now());

	    branch = repo.save(branch);
	    return mapToResponse(branch);
	}

	@Override
	public BranchResponse getBranchById(UUID id) {
		
		 return repo.findById(id)
		            .map(this::mapToResponse)
		            .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + id));
	}

	@Override
	public List<BranchResponse> getAllBranches() {
		return repo.findAll()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteBranch(UUID id) {
		
		repo.deleteById(id);
	}
	
	

}
