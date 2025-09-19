package com.yhoh.healthcarepharmacy.master.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yhoh.healthcarepharmacy.master.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID>{

	boolean existsByCode(String code);
    boolean existsByName(String name);
    
}
