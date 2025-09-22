package com.yhoh.healthcarepharmacy.employee.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yhoh.healthcarepharmacy.employee.dto.EmployeeRequest;
import com.yhoh.healthcarepharmacy.employee.dto.EmployeeResponse;
import com.yhoh.healthcarepharmacy.employee.entity.Employee;
import com.yhoh.healthcarepharmacy.employee.repository.EmployeeRepository;
import com.yhoh.healthcarepharmacy.exception.ResourceNotFoundException;
import com.yhoh.healthcarepharmacy.master.entity.Branch;
import com.yhoh.healthcarepharmacy.master.repository.BranchRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository empRepo;
	private final BranchRepository brnRepo;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo,BranchRepository brnRepo) {
		
		this.empRepo= empRepo;
		this.brnRepo= brnRepo;
	}

	private EmployeeResponse mapToResponse(Employee emp) {
        EmployeeResponse dto = new EmployeeResponse();
        dto.setId(emp.getId());
        dto.setCode(emp.getCode());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setPhone(emp.getPhone());
        dto.setDesignation(emp.getDesignation());
        dto.setStatus(emp.getStatus());

        if(emp.getBranch() != null) {
            dto.setBranchId(emp.getBranch().getId().toString());
            dto.setBranchName(emp.getBranch().getName());
        }

        return dto;
    }

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest dto) {
	    Employee emp = new Employee();
	    emp.setCode(dto.getCode());
	    emp.setFirstName(dto.getFirstName());
	    emp.setLastName(dto.getLastName());
	    emp.setEmail(dto.getEmail());
	    emp.setPhone(dto.getPhone());
	    emp.setDesignation(dto.getDesignation());
	    emp.setStatus(dto.getStatus());

	    if(dto.getBranchId() != null) {
	        Branch branch = brnRepo.findById(UUID.fromString(dto.getBranchId()))
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Branch not found with id: " + dto.getBranchId()
	                ));
	        emp.setBranch(branch);
	    }

	    Employee saved = empRepo.save(emp);
	    return mapToResponse(saved);
	}


	@Override
	public EmployeeResponse updateEmployee(String id, EmployeeRequest dto) {
	    // Fetch existing employee by UUID string
	    Employee employee = empRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

	    // Update employee basic fields
	    employee.setCode(dto.getCode());
	    employee.setFirstName(dto.getFirstName());
	    employee.setLastName(dto.getLastName());
	    employee.setEmail(dto.getEmail());
	    employee.setPhone(dto.getPhone());
	    employee.setDesignation(dto.getDesignation());
	    employee.setStatus(dto.getStatus());

	    // Update branch if branchId is provided
	    if (dto.getBranchId() != null) {
	        Branch branch = brnRepo.findById(UUID.fromString(dto.getBranchId()))
	                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + dto.getBranchId()));
	        employee.setBranch(branch);
	    }
	    Employee updated = empRepo.save(employee);

	    return mapToResponse(updated);
	}


	@Override
	public EmployeeResponse getEmployeeById(String id) {
		
		return empRepo.findById(id).map(this::mapToResponse)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
	}

	@Override
	public List<EmployeeResponse> getAllEmployees() {
		return empRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteEmployee(String id) {
		
		empRepo.deleteById(id);
	}
	
	
	
}